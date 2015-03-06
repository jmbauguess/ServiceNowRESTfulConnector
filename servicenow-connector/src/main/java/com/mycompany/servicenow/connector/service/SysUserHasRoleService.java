package com.mycompany.servicenow.connector.service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.servicenow.connector.model.*;
import org.apache.http.client.HttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Justin Bauguess
 */
@Service("sysuserhasroleService")
public class SysUserHasRoleService extends BasicService {
    
    private final String userUrl = "sys_user_has_role.do?JSON&sysparm_action=getRecords&displayvalue=true";
    private final String itilUrl = "sys_user_has_role.do?JSON&sysparm_action=getRecords&displayvalue=true&sysparm_query=role.name=itil";
    
    public SysUserHasRoleService() {
        super();
    }
    
    public List<SysUserHasRole> getUsersAndRoles(String role) throws IOException {
        HttpClient httpClient = getDefaultHttpClient();
        String responseBody = httpClient.execute(buildHttpGet(getBaseUrl() + userUrl), buildResponseHandler());
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        SysUserHasRoleCollection collection = (gson).fromJson(responseBody, SysUserHasRoleCollection.class);
        if (!role.equals("")){
            return limitResultsByRole(collection.getsysUserHasRoles(), role);
        } else {
            return collection.getsysUserHasRoles();
        }
    }
    
    public List<SysUserHasRole> getItilUsers(boolean random) throws IOException {
        HttpClient httpClient = getDefaultHttpClient();
        String responseBody = httpClient.execute(buildHttpGet(getBaseUrl() + itilUrl), buildResponseHandler());
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        SysUserHasRoleCollection collection = (gson).fromJson(responseBody, SysUserHasRoleCollection.class);
        if (random){
            return giveMeARandom(collection.getsysUserHasRoles());
        } else {
            return collection.getsysUserHasRoles();
        }
    }      
    
    private List<SysUserHasRole> limitResultsByRole(List<SysUserHasRole> users, final String role) {
        return Lists.newArrayList(Iterables.filter(users, new Predicate<SysUserHasRole>() {
            @Override
            public boolean apply(SysUserHasRole user) {
                String urole = user.getRole();
                return (urole != null) && (urole.equalsIgnoreCase(role));
            }
        }));
    }
    
    private List<SysUserHasRole> giveMeARandom(List<SysUserHasRole> users){
        Random rand = new Random();
        int randomInt = rand.nextInt((users.size()) + 1);
        List<SysUserHasRole> returnList = new ArrayList<SysUserHasRole>();
        returnList.add(users.get(randomInt));
        return returnList;
    }
    
}
