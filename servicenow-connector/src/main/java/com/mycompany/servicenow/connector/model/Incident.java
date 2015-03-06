package com.mycompany.servicenow.connector.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Incident extends Task {

    @SerializedName("business_stc")
    private String businessStc;

    @SerializedName("calendar_stc")
    private String calendarStc;

    @SerializedName("caller_id")
    private String callerId;

    @SerializedName("category")
    private String category;

    @SerializedName("caused_by")
    private String causedBy;

    @SerializedName("child_incidents")
    private String childIncidents;

    @SerializedName("close_code")
    private String closeCode;

    @SerializedName("incident_state")
    private String incidentState;

    @SerializedName("notify")
    private String notify;

    @SerializedName("parent_incident")
    private String parentIncident;

    @SerializedName("problem_id")
    private String problemId;

    @SerializedName("reopen_count")
    private String reopenCount;

    @SerializedName("resolved_at")
    private String resolvedAt;

    @SerializedName("resolved_by")
    private String resolvedBy;

    @SerializedName("rfc")
    private String rfc;

    @SerializedName("severity")
    private String severity;

    @SerializedName("subcategory")
    private String subcategory;

    @SerializedName("u_alternate_call_back")
    private String uAlternateCallBack;

    @SerializedName("u_alternate_contact")
    private String uAlternateContact;

    @SerializedName("u_asset")
    private String uAsset;

    @SerializedName("u_business_applications")
    private String uBusinessApplications;

    @SerializedName("u_business_impact")
    private String uBusinessImpact;

    @SerializedName("u_business_service")
    private String uBusinessService;

    @SerializedName("u_business_services")
    private String uBusinessServices;

    @SerializedName("u_call_back_number")
    private String uCallBackNumber;

    @SerializedName("u_case_type")
    private String uCaseType;

    @SerializedName("u_duration_of_major_incident")
    private String uDurationOfMajorIncident;

    @SerializedName("u_email_uid")
    private String uEmailUid;

    @SerializedName("u_locations_impacted")
    private String uLocationsImpacted;

    @SerializedName("u_major_incident")
    private boolean uMajorIncident;

    @SerializedName("u_manually_added")
    private String uManuallyAdded;

    @SerializedName("u_opened_shift")
    private String uOpenedShift;

    @SerializedName("u_reference_id")
    private String uReferenceId;

    @SerializedName("u_resolution_action")
    private String uResolutionAction;

    @SerializedName("u_resolved_shift")
    private String uResolvedShift;

    @SerializedName("u_service_outage_time")
    private String uServiceOutageTime;

    @SerializedName("u_service_restoration_time")
    private String uServiceRestorationTime;

    @SerializedName("u_summary_notes")
    private String uSummaryNotes;

    @SerializedName("u_users_impacted")
    private String uUsersImpacted;

//Getters and Setters
    public String getBusinessStc() {
        return this.businessStc;
    }

    public void setBusinessStc(String value) {
        this.businessStc = value;
    }

    public String getCalendarStc() {
        return this.calendarStc;
    }

    public void setCalendarStc(String value) {
        this.calendarStc = value;
    }

    public String getCallerId() {
        return this.callerId;
    }

    public void setCallerId(String value) {
        this.callerId = value;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String value) {
        this.category = value;
    }

    public String getCausedBy() {
        return this.causedBy;
    }

    public void setCausedBy(String value) {
        this.causedBy = value;
    }

    public String getChildIncidents() {
        return this.childIncidents;
    }

    public void setChildIncidents(String value) {
        this.childIncidents = value;
    }

    public String getCloseCode() {
        return this.closeCode;
    }

    public void setCloseCode(String value) {
        this.closeCode = value;
    }

    public String getIncidentState() {
        return this.incidentState;
    }

    public void setIncidentState(String value) {
        this.incidentState = value;
    }

    public String getNotify() {
        return this.notify;
    }

    public void setNotify(String value) {
        this.notify = value;
    }

    public String getParentIncident() {
        return this.parentIncident;
    }

    public void setParentIncident(String value) {
        this.parentIncident = value;
    }

    public String getProblemId() {
        return this.problemId;
    }

    public void setProblemId(String value) {
        this.problemId = value;
    }

    public String getReopenCount() {
        return this.reopenCount;
    }

    public void setReopenCount(String value) {
        this.reopenCount = value;
    }

    public String getResolvedAt() {
        return this.resolvedAt;
    }

    public void setResolvedAt(String value) {
        this.resolvedAt = value;
    }

    public String getResolvedBy() {
        return this.resolvedBy;
    }

    public void setResolvedBy(String value) {
        this.resolvedBy = value;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String value) {
        this.rfc = value;
    }

    public String getSeverity() {
        return this.severity;
    }

    public void setSeverity(String value) {
        this.severity = value;
    }

    public String getSubcategory() {
        return this.subcategory;
    }

    public void setSubcategory(String value) {
        this.subcategory = value;
    }

    public String getUAlternateCallBack() {
        return this.uAlternateCallBack;
    }

    public void setUAlternateCallBack(String value) {
        this.uAlternateCallBack = value;
    }

    public String getUAlternateContact() {
        return this.uAlternateContact;
    }

    public void setUAlternateContact(String value) {
        this.uAlternateContact = value;
    }

    public String getUAsset() {
        return this.uAsset;
    }

    public void setUAsset(String value) {
        this.uAsset = value;
    }

    public String getUBusinessApplications() {
        return this.uBusinessApplications;
    }

    public void setUBusinessApplications(String value) {
        this.uBusinessApplications = value;
    }

    public String getUBusinessImpact() {
        return this.uBusinessImpact;
    }

    public void setUBusinessImpact(String value) {
        this.uBusinessImpact = value;
    }

    public String getUBusinessService() {
        return this.uBusinessService;
    }

    public void setUBusinessService(String value) {
        this.uBusinessService = value;
    }

    public String getUBusinessServices() {
        return this.uBusinessServices;
    }

    public void setUBusinessServices(String value) {
        this.uBusinessServices = value;
    }

    public String getUCallBackNumber() {
        return this.uCallBackNumber;
    }

    public void setUCallBackNumber(String value) {
        this.uCallBackNumber = value;
    }

    public String getUCaseType() {
        return this.uCaseType;
    }

    public void setUCaseType(String value) {
        this.uCaseType = value;
    }

    public String getUDurationOfMajorIncident() {
        return this.uDurationOfMajorIncident;
    }

    public void setUDurationOfMajorIncident(String value) {
        this.uDurationOfMajorIncident = value;
    }

    public String getUEmailUid() {
        return this.uEmailUid;
    }

    public void setUEmailUid(String value) {
        this.uEmailUid = value;
    }

    public String getULocationsImpacted() {
        return this.uLocationsImpacted;
    }

    public void setULocationsImpacted(String value) {
        this.uLocationsImpacted = value;
    }

    public boolean getUMajorIncident() {
        return this.uMajorIncident;
    }

    public void setUMajorIncident(boolean value) {
        this.uMajorIncident = value;
    }

    public String getUManuallyAdded() {
        return this.uManuallyAdded;
    }

    public void setUManuallyAdded(String value) {
        this.uManuallyAdded = value;
    }

    public String getUOpenedShift() {
        return this.uOpenedShift;
    }

    public void setUOpenedShift(String value) {
        this.uOpenedShift = value;
    }

    public String getUReferenceId() {
        return this.uReferenceId;
    }

    public void setUReferenceId(String value) {
        this.uReferenceId = value;
    }

    public String getUResolutionAction() {
        return this.uResolutionAction;
    }

    public void setUResolutionAction(String value) {
        this.uResolutionAction = value;
    }

    public String getUResolvedShift() {
        return this.uResolvedShift;
    }

    public void setUResolvedShift(String value) {
        this.uResolvedShift = value;
    }

    public String getUServiceOutageTime() {
        return this.uServiceOutageTime;
    }

    public void setUServiceOutageTime(String value) {
        this.uServiceOutageTime = value;
    }

    public String getUServiceRestorationTime() {
        return this.uServiceRestorationTime;
    }

    public void setUServiceRestorationTime(String value) {
        this.uServiceRestorationTime = value;
    }

    public String getUSummaryNotes() {
        return this.uSummaryNotes;
    }

    public void setUSummaryNotes(String value) {
        this.uSummaryNotes = value;
    }

    public String getUUsersImpacted() {
        return this.uUsersImpacted;
    }

    public void setUUsersImpacted(String value) {
        this.uUsersImpacted = value;
    }

}
