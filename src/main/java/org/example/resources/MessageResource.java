package org.example.resources;

import org.example.model.Message;
import org.example.resources.beans.MessageFilterBean;
import org.example.service.MessageService;

import javax.ws.rs.*;
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
    @Produces(MediaType.APPLICATION_JSON) //Indicates that the response is JSON
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean)
    {
        if(filterBean.getYear() > 0)
        {
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }
        if(filterBean.getStart() >= 0 && filterBean.getSize() > 0)
        {
            return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        }
        return messageService.getAllMessages();
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id, Message message)
    {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMessage(@PathParam("messageId") long id)
    {
        messageService.removeMessage(id);
    }


    @POST //Map the method to the HTTP POST method
    @Consumes(MediaType.APPLICATION_JSON) //This annotation tells Jersey that it will be accepting JSON input
    @Produces(MediaType.APPLICATION_JSON) //This annotation tells Jersey that it will be producing JSON output
    public Message addMessage(Message message)
    {
        return messageService.addMessage(message);
    }

    @GET
    @Path("/{messageId}") //Map to subsequent path /messages/{messageId}
    @Produces(MediaType.APPLICATION_JSON)
    //Uses the PathParam feature to grab the parameter from the URL
    //Furthermore, this utilizes Jersey's inbuilt autoboxing and unboxing for PathParams
    public Message getMessage(@PathParam("messageId") long messageId)
    {
        return messageService.getMessage(messageId);
    }

}
