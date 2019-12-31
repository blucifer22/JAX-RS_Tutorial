package org.example.resources;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("/annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("customHeaderValue") String header,
                                            @CookieParam("name") String cookie)
    {
        return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie: " + cookie;
    }
}
