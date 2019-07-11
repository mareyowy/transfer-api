package com.marey.transferapi.transfer.repository;

import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransferRepository {

    Long saveTransfer(Transfer transfer);
    List<Transfer> getTransferList(Iban iban);
    List<Transfer> getTransferList(Long userId);
    Transfer getTransferDetails(Long transferId);
    BigDecimal getTodayAmountSum(Iban iban, LocalDate dateTime);
}
