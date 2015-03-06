package com.mycompany.servicenow.connector.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class IncidentCollection {

    @SerializedName("records")
    private List<Incident> incidents;

    public List<Incident> getIncidents() {
        return incidents;
    }

}
