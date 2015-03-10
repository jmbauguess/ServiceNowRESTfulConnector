package com.mycompany.servicenow.connector.resource;


import com.mycompany.servicenow.connector.model.Incident;
import com.mycompany.servicenow.connector.service.IncidentService;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author Justin Bauguess
 */
@Controller("incidentResource")
@Path("incident")
public class IncidentResource {
    
    @Resource
    private IncidentService incidentService;
    
    @GET
    @Path("incidents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Incident> getAllIncidents(
            @DefaultValue("") @QueryParam("group") String group,
            @DefaultValue("") @QueryParam("sort_field") String sortField) {
        try {
            return incidentService.getAllNewIncidentsForGroup(group, sortField);
        } catch (IOException exception) {
            String message = "A problem occurred calling ServiceNowService:getAllNewIncidentsForGroup";
            throw new WebServiceException(message, exception);
        }
    }
    
    @GET
    @Path("incident/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Incident getIncidentByNumber(
            @PathParam("number") String number) {
        try {
            return incidentService.getIncidentByNumber(number);
        } catch (IOException exception) {
            String message = "A problem occurred calling ServiceNowService:getIncidentByNumber(" + number + ")";
            throw new WebServiceException(message, exception);
        }
    }
    
    @POST
    @Path("incident")
    @Produces(MediaType.APPLICATION_JSON)
    public void addNewIncident(@RequestBody Incident incident) {        
        try {
            incidentService.addIncident(incident);        
        } catch (IOException e){
            String message = "A problem occurred calling ServiceNowService:addIncident";
            throw new WebServiceException(message, e);
        }        
    }
    
    @DELETE
    @Path("incident/{sys_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteIncidentBySysID(@PathParam("sys_id") String sys_id) {
        try {
            incidentService.deleteIncident(sys_id);
        } catch (IOException e) {
            String message = "A problem occurred calling ServiceNowService:deleteIncidentBySysID";
            throw new WebServiceException(message, e);
        }
    }
    
    @PUT
    @Path("incident/{num}")
    public Incident updateIncidentByNumber(@RequestBody Incident incident, @PathParam("num") String number) {
        try {
            return incidentService.updateIncident(incident, number);
        } catch (IOException e) {
            String message = "A problem occurred calling ServiceNowService:updateIncidentByNumber";
            throw new WebServiceException(message, e);
        }
    }
    
    
}
