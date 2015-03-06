package com.mycompany.servicenow.connector.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Justin Bauguess
 */
public class BasicService {

    private String baseUrl;
    private String username;
    private String password;
    Properties prop = new Properties();
    
    public BasicService(){
        try {
            InputStream inputStream
                    = IncidentService.class.getClassLoader().getResourceAsStream("incident.properties");
            prop.load(inputStream);
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            baseUrl = "https://" + prop.getProperty("instance") + ".service-now.com/";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected HttpClient getDefaultHttpClient() {
        return HttpClientBuilder.create().build();
    }

    protected HttpGet buildHttpGet(String url) {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(getUsername(), getPassword());
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(BasicScheme.authenticate(credentials, "UTF-8", false));
        return httpGet;
    }

    protected ResponseHandler<String> buildResponseHandler() {
        return new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                if ((status >= 200) && (status < 300)) {
                    HttpEntity entity = response.getEntity();
                    return (entity != null) ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
    }        

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
