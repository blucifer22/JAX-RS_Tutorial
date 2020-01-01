package org.example.resources;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    /**
     * This is a sample HTTP GET method to demonstrate some different types of injection
     * params. All of the params are extracted using JAX-RS annotations as shown below
     * @param matrixParam This variable holds a MatrixParam formatted URL component (;key=value)
     * @param header This variable holds a Param extracted from the HTTP header sent with the GET request
     * @param cookie This variable holds a Param extracted from a cookie sent with the GET request
     * @return a labeled plaintext representation of the different parameters.
     */
    @GET
    @Path("/annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("customHeaderValue") String header,
                                            @CookieParam("name") String cookie)
    {
        return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie: " + cookie;
    }
}
