# ServiceNowRESTfulConnector

Uses Webservices to connect to ServiceNow and return JSON data

First, use the script or update set to generate java classes with the proper annotations.  Next, create service classes as needed.  Finally, create resource classes to act as end points for your service.  Add any authentication you need, and you're good to go.  (I did not choose to include any external authentication, leaving that up to you.)

Included is an example that has Incidents and Users.  The goal was to be able to get a random user with a certain role (itil, in this case).  Once deployed, this service can be called to get that information.

Of course, the code in this can be brought into any larger project if needed.
