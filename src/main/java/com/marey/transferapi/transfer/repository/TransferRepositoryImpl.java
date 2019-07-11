package com.marey.transferapi.transfer.repository;

import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TransferRepositoryImpl implements TransferRepository{

    private Set<Transfer> transfers = new HashSet<>();

    @Override
    public Long saveTransfer(Transfer transfer) {
        transfer.setId(transfers.size() + 1L);
        this.transfers.add(transfer);
        return transfer.getId();
    }

    @Override
    public List<Transfer> getTransferList(Iban iban) {
        return this.transfers.stream()
                .filter(transfer -> transfer.getSenderAccount().equals(iban))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transfer> getTransferList(Long userId) {
        return null;
    }

    @Override
    public Transfer getTransferDetails(Long transferId) {
        return transfers.stream()
                .filter(transfer -> transfer.getId().equals(transferId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public BigDecimal getTodayAmountSum(Iban iban, LocalDate dateTime) {
        return transfers.stream()
                .filter(transfer -> transfer.getSenderAccount().equals(iban)
                    && dateTime.equals(transfer.getSendDate()))
                .map(Transfer::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}


