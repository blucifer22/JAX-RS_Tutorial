package org.example.resources;

import org.example.model.Message;
import org.example.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages") //Annotation that adds this class to the /messages of the URL path (Top-Level annotation)
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
    @Produces(MediaType.APPLICATION_XML) //Indicates that the response is XML
    public List<Message> getMessages()
    {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}") //Map to subsequent path /messages/{messageId}
    @Produces(MediaType.APPLICATION_XML)
    //Uses the PathParam feature to grab the parameter from the URL
    //Furthermore, this utilizes Jersey's inbuilt autoboxing and unboxing for PathParams
    public Message getMessage(@PathParam("messageId") long messageId)
    {
        return messageService.getMessage(messageId);
    }

}
