package org.example.exception;

import org.example.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider //Tags this ExceptionMapper to JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "https://www.embarcfitness.com");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build(); //Returns a 404 NOT FOUND response with ErrorMessage
    }
}
