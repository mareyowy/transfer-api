package com.marey.transferapi.transfer.request;


import com.marey.transferapi.transfer.model.Transfer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferResponse {

    private Transfer transfer;

    private TransferResponseStatus responseStatus;

}
