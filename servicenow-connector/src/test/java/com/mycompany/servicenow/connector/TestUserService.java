package com.mycompany.servicenow.connector;

import com.mycompany.servicenow.connector.model.*;
import com.mycompany.servicenow.connector.resource.SysUserHasRoleResource;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Justin Bauguess
 */
public class TestUserService {
        
    @Mock
    private SysUserHasRoleResource userResource;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testRandomUserTrue(){
        List users = new LinkedList();
        users.add(new SysUserHasRole());           
        when(userResource.getRandomUsers(true)).thenReturn(users);
        List result = userResource.getRandomUsers(true);
        assertTrue("Get Random Users(true) returns just one record", result.size() == 1);
        verify(userResource).getRandomUsers(true);
    }
    
    @Test
    public void testRandomUserFalse(){
        List users = new LinkedList();
        for (int i = 0; i < 100; i++) {
            users.add(new SysUserHasRole());           
        }        
        when(userResource.getRandomUsers(false)).thenReturn(users);
        List result = userResource.getRandomUsers(false);
        assertTrue("Get Random Users(false) returns more than one record", result.size() == 100);
        verify(userResource).getRandomUsers(false);
    }
}
