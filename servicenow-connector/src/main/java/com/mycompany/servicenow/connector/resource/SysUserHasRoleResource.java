package com.mycompany.servicenow.connector.resource;

import com.mycompany.servicenow.connector.model.*;
import com.mycompany.servicenow.connector.service.*;
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
@Controller("sysuserhasroleController")
@Path("sysuserhasrole")
public class SysUserHasRoleResource {

    @Resource
    private SysUserHasRoleService userService;

    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SysUserHasRole> getAllUsers(
            @DefaultValue("") @QueryParam("role") String role) {
        try {
            return userService.getUsersAndRoles(role);
        } catch (IOException exception) {
            String message = "A problem occurred calling ServiceNowService:getAllNewIncidentsForGroup";
            throw new WebServiceException(message, exception);
        }
    }
    
    @GET
    @Path("randomuser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SysUserHasRole> getRandomUsers(
    @DefaultValue("true") @QueryParam("random") boolean random) {
        try {
            return userService.getItilUsers(random);
        } catch (IOException exception) {
            String message = "A problem occurred calling ServiceNowService:getAllNewIncidentsForGroup";
            throw new WebServiceException(message, exception);
        }
    }

}
