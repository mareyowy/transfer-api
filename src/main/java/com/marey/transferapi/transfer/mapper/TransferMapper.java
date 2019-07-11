package com.marey.transferapi.transfer.mapper;

import com.marey.transferapi.account.model.Account;
import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;
import com.marey.transferapi.transfer.request.TransferRequest;
import com.marey.transferapi.user.model.User;

import java.time.LocalDate;

public class TransferMapper {

    public static Transfer mapTransfer(TransferRequest request, User user, Account account) {

        return Transfer.builder()
                .amount(request.getAmount())
                .recipientAccount(Iban.of(request.getRecipientAccount()))
                .recipientAddress(request.getRecipientAddress())
                .recipientName(request.getRecipientName())
                .sendDate(LocalDate.now())
                .amount(request.getAmount())
                .title(request.getTitle())
                .senderName(user.getName())
                .senderAddress(user.getAddress())
                .senderAccount(Iban.of(request.getSenderAccount()))
                .balanceAfter(account.getAvailableFunds().subtract(request.getAmount()))
                .build();

    }
}
