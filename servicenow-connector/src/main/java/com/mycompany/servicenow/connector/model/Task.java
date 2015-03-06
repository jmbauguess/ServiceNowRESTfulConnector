package com.mycompany.servicenow.connector.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Task {

    @SerializedName("active")
    private boolean active;

    @SerializedName("activity_due")
    private String activityDue;

    @SerializedName("approval")
    private String approval;

    @SerializedName("approval_history")
    private String approvalHistory;

    @SerializedName("approval_set")
    private String approvalSet;

    @SerializedName("assigned_to")
    private String assignedTo;

    @SerializedName("assignment_group")
    private String assignmentGroup;

    @SerializedName("business_duration")
    private String businessDuration;

    @SerializedName("calendar_duration")
    private String calendarDuration;

    @SerializedName("closed_at")
    private String closedAt;

    @SerializedName("closed_by")
    private String closedBy;

    @SerializedName("close_notes")
    private String closeNotes;

    @SerializedName("cmdb_ci")
    private String cmdbCi;

    @SerializedName("comments")
    private String comments;

    @SerializedName("comments_and_work_notes")
    private String commentsAndWorkNotes;

    @SerializedName("company")
    private String company;

    @SerializedName("contact_type")
    private String contactType;

    @SerializedName("correlation_display")
    private String correlationDisplay;

    @SerializedName("correlation_id")
    private String correlationId;

    @SerializedName("delivery_plan")
    private String deliveryPlan;

    @SerializedName("delivery_task")
    private String deliveryTask;

    @SerializedName("description")
    private String description;

    @SerializedName("due_date")
    private String dueDate;

    @SerializedName("escalation")
    private String escalation;

    @SerializedName("expected_start")
    private String expectedStart;

    @SerializedName("follow_up")
    private String followUp;

    @SerializedName("group_list")
    private String groupList;

    @SerializedName("impact")
    private String impact;

    @SerializedName("knowledge")
    private boolean knowledge;

    @SerializedName("location")
    private String location;

    @SerializedName("made_sla")
    private boolean madeSla;

    @SerializedName("number")
    private String number;

    @SerializedName("opened_at")
    private String openedAt;

    @SerializedName("opened_by")
    private String openedBy;

    @SerializedName("order")
    private String order;

    @SerializedName("parent")
    private String parent;

    @SerializedName("priority")
    private String priority;

    @SerializedName("reassignment_count")
    private String reassignmentCount;

    @SerializedName("rejection_goto")
    private String rejectionGoto;

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("skills")
    private String skills;

    @SerializedName("sla_due")
    private String slaDue;

    @SerializedName("state")
    private String state;

    @SerializedName("sys_class_name")
    private String sysClassName;

    @SerializedName("sys_created_by")
    private String sysCreatedBy;

    @SerializedName("sys_created_on")
    private String sysCreatedOn;

    @SerializedName("sys_domain")
    private String sysDomain;

    @SerializedName("sys_id")
    private String sysId;

    @SerializedName("sys_mod_count")
    private String sysModCount;

    @SerializedName("sys_updated_by")
    private String sysUpdatedBy;

    @SerializedName("sys_updated_on")
    private String sysUpdatedOn;

    @SerializedName("time_worked")
    private String timeWorked;

    @SerializedName("upon_approval")
    private String uponApproval;

    @SerializedName("upon_reject")
    private String uponReject;

    @SerializedName("urgency")
    private String urgency;

    @SerializedName("user_input")
    private String userInput;

    @SerializedName("u_requested_for")
    private String uRequestedFor;

    @SerializedName("u_special_information")
    private String uSpecialInformation;

    @SerializedName("variables")
    private String variables;

    @SerializedName("watch_list")
    private String watchList;

    @SerializedName("wf_activity")
    private String wfActivity;

    @SerializedName("work_end")
    private String workEnd;

    @SerializedName("work_notes")
    private String workNotes;

    @SerializedName("work_notes_list")
    private String workNotesList;

    @SerializedName("work_start")
    private String workStart;

//Getters and Setters
    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean value) {
        this.active = value;
    }

    public String getActivityDue() {
        return this.activityDue;
    }

    public void setActivityDue(String value) {
        this.activityDue = value;
    }

    public String getApproval() {
        return this.approval;
    }

    public void setApproval(String value) {
        this.approval = value;
    }

    public String getApprovalHistory() {
        return this.approvalHistory;
    }

    public void setApprovalHistory(String value) {
        this.approvalHistory = value;
    }

    public String getApprovalSet() {
        return this.approvalSet;
    }

    public void setApprovalSet(String value) {
        this.approvalSet = value;
    }

    public String getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(String value) {
        this.assignedTo = value;
    }

    public String getAssignmentGroup() {
        return this.assignmentGroup;
    }

    public void setAssignmentGroup(String value) {
        this.assignmentGroup = value;
    }

    public String getBusinessDuration() {
        return this.businessDuration;
    }

    public void setBusinessDuration(String value) {
        this.businessDuration = value;
    }

    public String getCalendarDuration() {
        return this.calendarDuration;
    }

    public void setCalendarDuration(String value) {
        this.calendarDuration = value;
    }

    public String getClosedAt() {
        return this.closedAt;
    }

    public void setClosedAt(String value) {
        this.closedAt = value;
    }

    public String getClosedBy() {
        return this.closedBy;
    }

    public void setClosedBy(String value) {
        this.closedBy = value;
    }

    public String getCloseNotes() {
        return this.closeNotes;
    }

    public void setCloseNotes(String value) {
        this.closeNotes = value;
    }

    public String getCmdbCi() {
        return this.cmdbCi;
    }

    public void setCmdbCi(String value) {
        this.cmdbCi = value;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String value) {
        this.comments = value;
    }

    public String getCommentsAndWorkNotes() {
        return this.commentsAndWorkNotes;
    }

    public void setCommentsAndWorkNotes(String value) {
        this.commentsAndWorkNotes = value;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String value) {
        this.company = value;
    }

    public String getContactType() {
        return this.contactType;
    }

    public void setContactType(String value) {
        this.contactType = value;
    }

    public String getCorrelationDisplay() {
        return this.correlationDisplay;
    }

    public void setCorrelationDisplay(String value) {
        this.correlationDisplay = value;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    public String getDeliveryPlan() {
        return this.deliveryPlan;
    }

    public void setDeliveryPlan(String value) {
        this.deliveryPlan = value;
    }

    public String getDeliveryTask() {
        return this.deliveryTask;
    }

    public void setDeliveryTask(String value) {
        this.deliveryTask = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueString(String value) {
        this.dueDate = value;
    }

    public String getEscalation() {
        return this.escalation;
    }

    public void setEscalation(String value) {
        this.escalation = value;
    }

    public String getExpectedStart() {
        return this.expectedStart;
    }

    public void setExpectedStart(String value) {
        this.expectedStart = value;
    }

    public String getFollowUp() {
        return this.followUp;
    }

    public void setFollowUp(String value) {
        this.followUp = value;
    }

    public String getGroupList() {
        return this.groupList;
    }

    public void setGroupList(String value) {
        this.groupList = value;
    }

    public String getImpact() {
        return this.impact;
    }

    public void setImpact(String value) {
        this.impact = value;
    }

    public boolean getKnowledge() {
        return this.knowledge;
    }

    public void setKnowledge(boolean value) {
        this.knowledge = value;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String value) {
        this.location = value;
    }

    public boolean getMadeSla() {
        return this.madeSla;
    }

    public void setMadeSla(boolean value) {
        this.madeSla = value;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String value) {
        this.number = value;
    }

    public String getOpenedAt() {
        return this.openedAt;
    }

    public void setOpenedAt(String value) {
        this.openedAt = value;
    }

    public String getOpenedBy() {
        return this.openedBy;
    }

    public void setOpenedBy(String value) {
        this.openedBy = value;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String value) {
        this.order = value;
    }

    public String getParent() {
        return this.parent;
    }

    public void setParent(String value) {
        this.parent = value;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String value) {
        this.priority = value;
    }

    public String getReassignmentCount() {
        return this.reassignmentCount;
    }

    public void setReassignmentCount(String value) {
        this.reassignmentCount = value;
    }

    public String getRejectionGoto() {
        return this.rejectionGoto;
    }

    public void setRejectionGoto(String value) {
        this.rejectionGoto = value;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String value) {
        this.skills = value;
    }

    public String getSlaDue() {
        return this.slaDue;
    }

    public void setSlaDue(String value) {
        this.slaDue = value;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public String getSysClassName() {
        return this.sysClassName;
    }

    public void setSysClassName(String value) {
        this.sysClassName = value;
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

    public String getSysDomain() {
        return this.sysDomain;
    }

    public void setSysDomain(String value) {
        this.sysDomain = value;
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

    public String getTimeWorked() {
        return this.timeWorked;
    }

    public void setTimeWorked(String value) {
        this.timeWorked = value;
    }

    public String getUponApproval() {
        return this.uponApproval;
    }

    public void setUponApproval(String value) {
        this.uponApproval = value;
    }

    public String getUponReject() {
        return this.uponReject;
    }

    public void setUponReject(String value) {
        this.uponReject = value;
    }

    public String getUrgency() {
        return this.urgency;
    }

    public void setUrgency(String value) {
        this.urgency = value;
    }

    public String getUserInput() {
        return this.userInput;
    }

    public void setUserInput(String value) {
        this.userInput = value;
    }

    public String getURequestedFor() {
        return this.uRequestedFor;
    }

    public void setURequestedFor(String value) {
        this.uRequestedFor = value;
    }

    public String getUSpecialInformation() {
        return this.uSpecialInformation;
    }

    public void setUSpecialInformation(String value) {
        this.uSpecialInformation = value;
    }

    public String getVariables() {
        return this.variables;
    }

    public void setVariables(String value) {
        this.variables = value;
    }

    public String getWatchList() {
        return this.watchList;
    }

    public void setWatchList(String value) {
        this.watchList = value;
    }

    public String getWfActivity() {
        return this.wfActivity;
    }

    public void setWfActivity(String value) {
        this.wfActivity = value;
    }

    public String getWorkEnd() {
        return this.workEnd;
    }

    public void setWorkEnd(String value) {
        this.workEnd = value;
    }

    public String getWorkNotes() {
        return this.workNotes;
    }

    public void setWorkNotes(String value) {
        this.workNotes = value;
    }

    public String getWorkNotesList() {
        return this.workNotesList;
    }

    public void setWorkNotesList(String value) {
        this.workNotesList = value;
    }

    public String getWorkStart() {
        return this.workStart;
    }

    public void setWorkStart(String value) {
        this.workStart = value;
    }

}
