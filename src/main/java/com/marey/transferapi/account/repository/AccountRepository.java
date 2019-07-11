package com.marey.transferapi.account.repository;

import com.marey.transferapi.account.model.Account;
import com.marey.transferapi.transfer.model.Iban;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface AccountRepository {

    Account getAccount(Iban iban);
    List<Account> getUserAccounts(Long ownerId);
    void addAccount(Account account);
    boolean accountBelongsToUser(Iban iban, Long userId);
}
