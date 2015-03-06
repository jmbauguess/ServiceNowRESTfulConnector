package com.mycompany.servicenow.connector.service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.servicenow.connector.model.Incident;
import com.mycompany.servicenow.connector.model.IncidentCollection;
import org.apache.http.client.HttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Justin Bauguess
 */
@Service("incidentService")
public class IncidentService extends BasicService {
    
    private final String incidentsUrl = "incident.do?JSON&sysparm_action=getRecords&displayvalue=true&active=true";
    
    public IncidentService() {
        super();
    }

    public List<Incident> getAllNewIncidentsForGroup(String group, String sort) throws IOException {
        HttpClient httpClient = getDefaultHttpClient();
        String responseBody = httpClient.execute(buildHttpGet(getBaseUrl() + incidentsUrl), buildResponseHandler());
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        IncidentCollection collection = (gson).fromJson(responseBody, IncidentCollection.class);
        List<Incident> incidents = collection.getIncidents();
        if (!sort.equals("")) {
            sortIncidentResults(incidents, sort);
        } 
        if (!group.equals("")) {
            return limitResultsByGroup(collection.getIncidents(), group);
        }
        else {
            return collection.getIncidents();
        }
    }

    

    private List<Incident> limitResultsByGroup(List<Incident> incidents, final String group) {
        return Lists.newArrayList(Iterables.filter(incidents, new Predicate<Incident>() {
            @Override
            public boolean apply(Incident incident) {
                String assignmentGroup = incident.getAssignmentGroup();
                return (assignmentGroup != null) && (assignmentGroup.equalsIgnoreCase(group));
            }
        }));
    }   
    
    private List<Incident> sortIncidentResults(List<Incident> incidents,
                                                              String sortField) throws IOException {
        if (sortField.equals("number")) {
            sortByNumber(incidents);
            return incidents;
        } else if (sortField.equals("short_description")){
            sortByShortDescription(incidents);
            return incidents;
        } else {
            sortByShortDescription(incidents);
            return incidents;
        }
    }
    
    private void sortByNumber(List<Incident> businessServices) {
        Collections.sort(businessServices, new Comparator<Incident>() {
            @Override
            public int compare(Incident o1, Incident o2) {
                if (o1.getNumber() == null) {
                    return 0;
                } else {
                    return o1.getNumber().compareTo(o2.getNumber());
                }
            }
        });
    }

    private void sortByShortDescription(List<Incident> businessServices) {
        Collections.sort(businessServices, new Comparator<Incident>() {
            @Override
            public int compare(Incident o1, Incident o2) {
                if (o1.getShortDescription() == null) {
                    return 0;
                } else {
                    return o1.getShortDescription().compareTo(o2.getShortDescription());
                }
            }
        });
    }

}
