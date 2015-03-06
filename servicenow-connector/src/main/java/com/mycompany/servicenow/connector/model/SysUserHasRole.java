package com.mycompany.servicenow.connector.model;

import com.google.gson.annotations.SerializedName;

public class SysUserHasRole {

    @SerializedName("granted_by")
    private String grantedBy;

    @SerializedName("included_in_role")
    private String includedInRole;

    @SerializedName("included_in_role_instance")
    private String includedInRoleInstance;

    @SerializedName("inherited")
    private boolean inherited;

    @SerializedName("role")
    private String role;

    @SerializedName("state")
    private String state;

    @SerializedName("sys_created_by")
    private String sysCreatedBy;

    @SerializedName("sys_created_on")
    private String sysCreatedOn;

    @SerializedName("sys_id")
    private String sysId;

    @SerializedName("sys_mod_count")
    private String sysModCount;

    @SerializedName("sys_updated_by")
    private String sysUpdatedBy;

    @SerializedName("sys_updated_on")
    private String sysUpdatedOn;

    @SerializedName("user")
    private String user;

    //Getters and Setters
    
    public String getGrantedBy() {
        return this.grantedBy;
    }

    public void setGrantedBy(String value) {
        this.grantedBy = value;
    }

    public String getIncludedInRole() {
        return this.includedInRole;
    }

    public void setIncludedInRole(String value) {
        this.includedInRole = value;
    }

    public String getIncludedInRoleInstance() {
        return this.includedInRoleInstance;
    }

    public void setIncludedInRoleInstance(String value) {
        this.includedInRoleInstance = value;
    }

    public boolean getInherited() {
        return this.inherited;
    }

    public void setInherited(boolean value) {
        this.inherited = value;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String value) {
        this.role = value;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public String getSysCreatedBy() {
        return this.sysCreatedBy;
    }

    public void setSysCreatedBy(String value) {
        this.sysCreatedBy = value;
    }

    public String getSysCreatedOn() {
        return this.sysCreatedOn;
    }

    public void setSysCreatedOn(String value) {
        this.sysCreatedOn = value;
    }

    public String getSysId() {
        return this.sysId;
    }

    public void setSysId(String value) {
        this.sysId = value;
    }

    public String getSysModCount() {
        return this.sysModCount;
    }

    public void setSysModCount(String value) {
        this.sysModCount = value;
    }

    public String getSysUpdatedBy() {
        return this.sysUpdatedBy;
    }

    public void setSysUpdatedBy(String value) {
        this.sysUpdatedBy = value;
    }

    public String getSysUpdatedOn() {
        return this.sysUpdatedOn;
    }

    public void setSysUpdatedOn(String value) {
        this.sysUpdatedOn = value;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String value) {
        this.user = value;
    }

}
