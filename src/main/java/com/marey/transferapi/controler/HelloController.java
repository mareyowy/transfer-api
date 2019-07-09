package com.marey.transferapi.controler;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloController {

    @GET
    public Response helloWorld() {
        return Response.ok("Hello world").build();
    }
}
