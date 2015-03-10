package com.mycompany.servicenow.connector.service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.servicenow.connector.model.Incident;
import com.mycompany.servicenow.connector.model.IncidentCollection;
import java.io.BufferedReader;
import org.apache.http.client.HttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

/**
 *
 * @author Justin Bauguess
 */
@Service("incidentService")
public class IncidentService extends BasicService {
    
    private final String incidentsUrl = "incident.do?JSON&sysparm_action=getRecords&displayvalue=true&active=true";
    private final String incidentUrl = "incident.do?JSON&sysparm_action=getRecords&displayvalue=true&sysparm_query=number=";
    private final String postUrl = "incident.do?JSON&sysparm_action=insert&displayvalue=true";
    private final String putUrl = "incident.do?JSON&sysparm_query=number=";
    private final String deleteUrl = "incident.do?JSON&sysparm_action=deleteRecord&sysparm_sys_id=";
    
    public IncidentService() {
        super();
    }
    
    /**
     * Gets an incident by the display number (ie: INC000001) and not the sys_id
     * @param number The display number of the incident
     * @return the incident
     * @throws IOException 
     */
    public Incident getIncidentByNumber(String number) throws IOException {
        HttpClient httpClient = getDefaultHttpClient();
        String responseBody = httpClient.execute(buildHttpGet(getBaseUrl() + incidentUrl + number), buildResponseHandler());
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        IncidentCollection collection = (gson).fromJson(responseBody, IncidentCollection.class);
        List<Incident> incidents = collection.getIncidents();
        if (incidents.get(0) != null){
            return incidents.get(0);
        } else {
            return new Incident();
        }
    }
    
    public Incident updateIncident(Incident incident, String number) throws IOException {
        HttpClient httpClient = getDefaultHttpClient();
        HttpPost post = buildHttpPost(buildPutUrl(number));        
        Gson gson = new GsonBuilder().serializeNulls().create();
        StringEntity entity = new StringEntity(gson.toJson(incident));        
        post.setEntity(entity);
        
        HttpResponse response = httpClient.execute(post); 
        String responseBody = response.getEntity().toString();
        InputStream is = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        return new Incident();
    }
    
    public boolean deleteIncident(String sys_id) throws IOException {
        HttpClient httpClient = getDefaultHttpClient();
        HttpPost httpPost = buildHttpPost(getBaseUrl() + deleteUrl + sys_id);
        httpClient.execute(httpPost, buildResponseHandler());
        return true;
    }
    
    public Incident addIncident(Incident incident) throws IOException {
        HttpClient httpClient = getDefaultHttpClient();
        HttpPost post = buildHttpPost(getBaseUrl() + postUrl);  
        System.out.println("SD:" + incident.getShortDescription());
        Gson gson = new GsonBuilder().create();
        StringEntity entity = new StringEntity(gson.toJson(incident));
        post.setEntity(entity);
        String responseBody = httpClient.execute(post, buildResponseHandler());   
        return new Incident();
    }
    
    public String buildPutUrl(String query) {
        return getBaseUrl() + putUrl + query + "&sysparm_action=update";
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
