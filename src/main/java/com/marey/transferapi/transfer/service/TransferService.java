package com.marey.transferapi.transfer.service;

import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;
import com.marey.transferapi.transfer.request.TransferResponse;

import java.util.List;

public interface TransferService {

    TransferResponse saveTransfer(Transfer transfer);
    List<Transfer> getTransfers(Long userId);
    List<Transfer> getTransfers(Iban iban);
    Transfer getTransferDetails(Long transferId);


}
