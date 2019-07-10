package com.marey.transferapi.transfer.controler;


import com.marey.transferapi.transfer.request.TransferRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transfer")
public class TransferController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendTransfer(TransferRequest request) {
        return null;
    }
}
