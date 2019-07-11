package com.marey.transferapi.transfer.service;

import com.marey.transferapi.account.repository.AccountRepository;
import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;
import com.marey.transferapi.transfer.repository.TransferRepository;
import com.marey.transferapi.transfer.request.TransferRequest;
import com.marey.transferapi.transfer.request.TransferResponse;
import com.marey.transferapi.user.repository.UserRepository;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class TransferServiceImpl implements TransferService {

    public TransferServiceImpl(AccountRepository accountRepository, UserRepository userRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.transferRepository = transferRepository;
    }

    @Inject
    private AccountRepository accountRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private TransferRepository transferRepository;

    @Override
    public TransferResponse saveTransfer(TransferRequest transfer) {
        return null;
    }

    @Override
    public List<Transfer> getTransfers(Long userId) {
        return null;
    }

    @Override
    public List<Transfer> getTransfers(Iban iban) {
        return null;
    }

    @Override
    public Transfer getTransferDetails(Long transferId) {
        return null;
    }
}
