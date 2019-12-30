package org.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages") //Annotation that adds this class to the /messages of the URL path
public class MessageResource {

    @GET //Maps the getter method to the GET HTTP method!
    @Produces(MediaType.TEXT_PLAIN) //Indicates that the response is plain text
    public String getMessages()
    {
        return "Hello world!";
    }
}
