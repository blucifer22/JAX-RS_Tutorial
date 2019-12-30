package org.example.resources;

import org.example.model.Message;
import org.example.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages") //Annotation that adds this class to the /messages of the URL path
public class MessageResource {

    MessageService messageService = new MessageService();

    /**
     * This method acts as a HTTP GET method (resource handler) for a
     * basic "list all messages" response.
     * It is annotated with @GET to indicate this to Jersey
     * Additionally, it is annotated with @Produces to so that the
     * servlet knows it will be receiving APPLICATION_XML.
     * @return An XML representation of all the messages on the server
     */
    @GET //Maps the getter method to the GET HTTP method!
    @Produces(MediaType.APPLICATION_XML) //Indicates that the response is plain text
    public List<Message> getMessages()
    {
        return messageService.getAllMessages();
    }
}
