package com.marey.transferapi.transfer.repository;

import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface TransferRepository {

    Long saveTransfer(Transfer transfer);
    List<Transfer> getTransferList(Iban iban);
    List<Transfer> getTransferList(Long userId);
    Transfer getTransferDetails(Long transferId);
}
