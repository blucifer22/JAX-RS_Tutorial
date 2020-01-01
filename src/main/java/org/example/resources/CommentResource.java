package org.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

    @GET
    public String test()
    {
        return "TEST!";
    }

    @GET
    @Path("/{commentId}") //Note: Since the parent, MessageResource method had the messageId with it it can grab that
    public String test2(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId)
    {
        return "Method to return comment ID: " + commentId + " for message " + messageId;
    }
}
