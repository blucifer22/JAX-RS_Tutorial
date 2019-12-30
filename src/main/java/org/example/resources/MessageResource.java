package org.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages") //Annotation that adds this class to the /messages of the URL path
public class MessageResource {

    /**
     * This method acts as a HTTP GET method (resource handler) for a
     * basic "Hello World" resource.
     * It is annotated with @GET to indicate this to Jersey
     * Additionally, it is annotated with @Produces to so that the
     * servlet knows it will be receiving plain text.
     * @return A plaintext "Hello world!" String
     */
    @GET //Maps the getter method to the GET HTTP method!
    @Produces(MediaType.TEXT_PLAIN) //Indicates that the response is plain text
    public String getMessages()
    {
        return "Hello world!";
    }
}
