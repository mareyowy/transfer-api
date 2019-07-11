package com.marey.transferapi.transfer.mapper;

import com.marey.transferapi.account.model.Account;
import com.marey.transferapi.transfer.model.Transfer;
import com.marey.transferapi.transfer.request.TransferRequest;
import com.marey.transferapi.user.model.User;

public class TransferMapper {

    public static Transfer mapTransfer(TransferRequest request, User user, Account account) {

        return Transfer.builder()
                .amount(request.getAmount())
                .recipientAccount(request.getRecipientAccount())
                .recipientAddress(request.getRecipientAddress())
                .recipientName(request.getRecipientName())
                .sendDate(request.getSendDate())
                .amount(request.getAmount())
                .title(request.getTitle())
                .senderName(user.getName())
                .senderAddress(user.getAddress())
                .senderAccount(request.getSenderAccount())
                .balanceAfter(account.getAvailableFunds().subtract(request.getAmount()))
                .build();

    }
}
