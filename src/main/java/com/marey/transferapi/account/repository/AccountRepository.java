package com.marey.transferapi.account.repository;

import com.marey.transferapi.account.model.Account;
import com.marey.transferapi.transfer.model.Iban;

import java.util.List;

public interface AccountRepository {

    Account getAccount(Iban iban);
    List<Account> getUserAccounts(Long ownerId);
    void addAccount(Account account);
}
