package com.marey.transferapi.transfer.service;

import com.marey.transferapi.account.model.Account;
import com.marey.transferapi.account.repository.AccountRepository;
import com.marey.transferapi.transfer.mapper.TransferMapper;
import com.marey.transferapi.transfer.model.Iban;
import com.marey.transferapi.transfer.model.Transfer;
import com.marey.transferapi.transfer.repository.TransferRepository;
import com.marey.transferapi.transfer.request.TransferRequest;
import com.marey.transferapi.transfer.request.TransferResponse;
import com.marey.transferapi.transfer.request.TransferResponseStatus;
import com.marey.transferapi.user.model.User;
import com.marey.transferapi.user.repository.UserRepository;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    private UserRepository userRepository;

    private TransferRepository transferRepository;

    @Inject
    public TransferServiceImpl(AccountRepository accountRepository, UserRepository userRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.transferRepository = transferRepository;
    }

    @Override
    public TransferResponse saveTransfer(TransferRequest request) {
        Account account = accountRepository.getAccount(Iban.of(request.getSenderAccount()));

        TransferResponseStatus status = validateTransfer(request, account);
        if(status.equals(TransferResponseStatus.OK)) {
            User user = userRepository.getUser(request.getUserId());
            Transfer transfer = TransferMapper.mapTransfer(request, user, account);
            Long transferId = transferRepository.saveTransfer(transfer);

            transfer.setId(transferId);
            account.setAvailableFunds(account.getAvailableFunds().subtract(transfer.getAmount()));

            return TransferResponse.of(transfer, status);
        } else {
            return TransferResponse.of(status);
        }
    }

    @Override
    public List<Transfer> getTransfers(Long userId) {
        return transferRepository.getTransferList(userId);
    }

    @Override
    public List<Transfer> getTransfers(Iban iban) {

        return transferRepository.getTransferList(iban);
    }

    @Override
    public Transfer getTransferDetails(Long transferId) {
        return transferRepository.getTransferDetails(transferId);
    }

    private TransferResponseStatus validateTransfer(TransferRequest request, Account account) {
        if(!accountRepository.accountBelongsToUser(Iban.of(request.getSenderAccount()), request.getUserId())) {
            return TransferResponseStatus.ACCOUNT_NOT_AVAILABLE;
        } else if(request.getAmount().compareTo(account.getAvailableFunds()) >= 1) {
            return TransferResponseStatus.FUNDS_NOT_AVAILABLE;
        } else if(checkIfLimitExceeded(request.getAmount(), account)) {
            return TransferResponseStatus.LIMIT_EXCEEDED;
        } else {
            return TransferResponseStatus.OK;
        }
    }

    private boolean checkIfLimitExceeded(BigDecimal amount, Account account) {
        BigDecimal usedLimit = transferRepository.getTodayAmountSum(account.getIban(), LocalDate.now());

        return usedLimit.add(amount).compareTo(account.getDailyLimit()) >= 1;
    }
}
