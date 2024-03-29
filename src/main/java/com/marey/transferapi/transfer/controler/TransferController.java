package com.marey.transferapi.transfer.controler;


import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.request.TransferRequest;
import com.marey.transferapi.transfer.service.TransferService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transfer")
@Singleton
public class TransferController {

    private TransferService transferService;

    @Inject
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response sendTransfer(TransferRequest request) {
        var response = transferService.saveTransfer(request);
        return Response.ok(response).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getTransferDetails(@PathParam("id") Long id) {
        var details = transferService.getTransferDetails(id);

        return Response.ok(details).build();
    }

    @GET
    @Path("/account/{iban}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getAccountTransfers(@PathParam("iban") String iban) {
        var userTransfers = transferService.getTransfers(Iban.of(iban));

        return Response.ok(userTransfers).build();
    }
}
