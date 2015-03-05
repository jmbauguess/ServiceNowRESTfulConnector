/**
 * ModelClassCreator - Creates Model Classes for RESTful services
 * @type {Class}
 */
var ModelClassCreator = Class.create();
ModelClassCreator.prototype = {
	/**
	 * initialize - Initializes values for the running of the script
	 * @param  {string} tableType          A table type (Task, CMDB) - Basically, any table that is extended
	 */
	initialize: function(tableType) {
		
		this.tableType = tableType;
	},
	/**
	 * getTaskTables Entry point for the class; creates records in the Class Generator Model table (or updates them)
	 */
	getTaskTables: function(){
		var gr = new GlideRecord('sys_db_object');
		gr.addEncodedQuery('super_class.name=' + this.tableType + '^ORname=' + this.tableType);
		gr.query();
		while(gr.next()){			
			var classTable = new GlideRecord('u_model_class_generator');
			classTable.addQuery('u_tablename', gr.name);
			classTable.query();
			if (classTable.next()){
				classTable.u_class_body = (this.getTableVariables(gr.name));
				classTable.update();
			} else {
				var newClassTable = new GlideRecord('u_model_class_generator');
				newClassTable.initialize();
				newClassTable.u_tablename = gr.name;
				newClassTable.u_class_body = (this.getTableVariables(gr.name));
				newClassTable.insert();
			}
		}
	},
	/**
	 * getTableVariables - Starts a dictionary table query based on the table and its parent
	 * @param  {string} tableName The table to query for
	 * @return {string}           Data to insert into the table
	 */
	getTableVariables: function (tableName){
		var gr = new GlideRecord('sys_dictionary');
		gr.addEncodedQuery('name=' + tableName + '^internal_type!=collection');
		gr.query();
		var data = this.getJavaVariables(gr, tableName);		
		return this.generateClass(data, tableName);
	},
	/**
	 * generateClass - Generates a class in the appropriate language
	 * @param  {string} data      A list of variables in a particular programming language
	 * @param  {string} tablename The table name of the class
	 * @return {string}           Data to insert into the table
	 */
	generateClass: function (data, tablename){
		var classToMake = 'package com.mycompany.servicenow.connector.model;\n\n' +
						  'import com.google.gson.annotations.SerializedName;\n\n';
		tablename = this.capitalizeFirstLetter(tablename);
		tablename = this.replaceUnderscoresWithCamelCase(tablename);
		if (tablename != 'Task' && this.tableType == 'task') {
			classToMake += 'public class ' + tablename + " extends Task {\n\n" + data + "\n}\n\n";		
		} else {
			classToMake += 'public class ' + tablename + " {\n\n" + data + "\n}\n\n";		
		}
		return classToMake;
	},
	/**
	 * capitalizeFirstLetter - Capitalizes the first letter of a word
	 * @param  {string} word The word to capitalize
	 * @return {string}      A word with the first word capitalized
	 */
	capitalizeFirstLetter: function (word){
		return word.charAt(0).toUpperCase() + word.slice(1);
	},
	/**
	 * replaceUnderscoresWithCamelCase - Takes a word and makes it camelCase
	 * @param  {string} item The string to make camelCase
	 * @return {string}      A camelCase version of the passed string
	 */
	replaceUnderscoresWithCamelCase: function (item){
		if (item.indexOf("_") > -1) {
			var strings = item.split("_");
			for (var i = 1; i < strings.length; i++){
				strings[i] = this.capitalizeFirstLetter(strings[i]);
			}
			return strings.join().replace(/,/g, '');
		}
		return item;
	},
	/**
	 * getJavaVariables - Creates variables based on the Java programming language
	 * @param  {GlideRecord} gr   Record containing dictionary entries
	 * @param  {string} tableName The tablename
	 * @return {string}           A list of variables
	 */
	getJavaVariables: function (gr, tableName){
		var data = '';
		while (gr.next()){
			var element = gr.element;
			element = this.replaceUnderscoresWithCamelCase(element);
			var elementType = this.getParentElementType(gr.internal_type);
			if (gr.element != 'sys_id') {
				data += ('@SerializedName("' + gr.element + '")\n');
			} else if (gr.element == 'sys_id' && tableName == 'task'){
				data += ('@SerializedName("' + gr.element + '")\n');
			}
			if (elementType == "boolean"){
				data += ("private boolean " + element + ";\n\n");
			} else if (elementType == "date" || elementType == "datetime" || elementType == "time"){
				data += ("private Date " + element + ";\n\n");
			} else if (elementType == "decimal" || elementType == "float") {
				data += ("private double " + element + ";\n\n");
			} else if (elementType == "integer") {
				data += ("private int " + element + ";\n\n")
			} else if (gr.element == 'sys_id' && tableName != this.tableType) {				
				//Skip duplicating the sys_id, which is at the task/parent level!				
			} else if (element == 'sys_id' && tableName == 'task') {
				data += ("private String " + element + ";\n\n");
			} else {
				data += ("private String " + element + ";\n\n");
			}
		}
		data += "\n\n//Getters and Setters\n\n";
		gr.restoreLocation();
		while (gr.next()) {
			var element = gr.element;
			element = this.replaceUnderscoresWithCamelCase(element);
			var elementName = this.capitalizeFirstLetter(element);
			if (elementType == "boolean"){
				data += ("public boolean get" + elementName + "() {\nreturn this." + element + ";\n}\n\n");				
			} else if (elementType == "date" || elementType == "datetime" || elementType == "time"){
				data += ("public Date get" + elementName + "() {\nreturn this." + element + ";\n}\n\n");
			} else if (elementType == "decimal" || elementType == "float") {
				data += ("public double get" + elementName + "() {\nreturn this." + element + ";\n}\n\n");
			} else if (elementType == "integer") {
				data += ("public int get" + elementName + "() {\nreturn this." + element + ";\n}\n\n");
			} else if (gr.element == 'sys_id' && tableName != this.tableType) {
				//Skip this getter/setter
			} else if (gr.element == 'sys_id' && tableName == this.tableType){
				data += ("public String get" + elementName + "() {\nreturn this." + element + ";\n}\n\n");
			} else {
				data += ("public String get" + elementName + "() {\nreturn this." + element + ";\n}\n\n");
			}
			if (gr.element != 'sys_id' && tableName != this.tableType) {				
				data += ("public void set" + elementName + "(value) {\nthis." + element + " = value;\n}\n\n");
			} else {
				data += ("public void set" + elementName + "(value) {\nthis." + element + " = value;\n}\n\n");
			}
		}
		return data;
	},
	/**
	 * getParentElementType Finds out what type of element we are dealing with
	 * @param  {String} elementName the type of element
	 * @return {String}             what the scalar_type of the element (ie: base type) is
	 */
	getParentElementType: function(elementName) {
		var obj = new GlideRecord('sys_glide_object');
		if (obj.get('name', elementName)) {
			return obj.scalar_type;
		}
		return 'String';
	},
	type: 'ModelClassCreator'
}