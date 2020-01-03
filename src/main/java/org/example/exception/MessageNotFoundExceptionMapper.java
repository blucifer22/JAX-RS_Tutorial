package org.example.exception;

import org.example.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MessageNotFoundExceptionMapper implements ExceptionMapper<MessageNotFoundException> {

    @Override
    public Response toResponse(MessageNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "https://www.embarcfitness.com");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
