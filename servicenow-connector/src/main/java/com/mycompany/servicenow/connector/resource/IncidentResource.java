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
    
}
