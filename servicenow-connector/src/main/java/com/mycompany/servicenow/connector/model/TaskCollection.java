package com.mycompany.servicenow.connector.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TaskCollection {

    @SerializedName("records")
    private List<Task> tasks;

    public List<Task> gettasks() {
        return tasks;
    }

}
