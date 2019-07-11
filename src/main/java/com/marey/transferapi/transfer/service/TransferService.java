package com.marey.transferapi.transfer.service;

import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;
import com.marey.transferapi.transfer.request.TransferRequest;
import com.marey.transferapi.transfer.request.TransferResponse;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface TransferService {

    TransferResponse saveTransfer(TransferRequest transfer);
    List<Transfer> getTransfers(Long userId);
    List<Transfer> getTransfers(Iban iban);
    Transfer getTransferDetails(Long transferId);


}
