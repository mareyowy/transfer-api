package com.marey.transferapi.account.repository;

import com.marey.transferapi.account.model.Account;
import com.marey.transferapi.transfer.model.Iban;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {

    private Set<Account> accounts = new HashSet<>();

    @PostConstruct
    public void init() {
        Account account = Account.builder()
                .accountName("Konto osobiste")
                .balance(BigDecimal.valueOf(1000L))
                .availableFunds(BigDecimal.valueOf(1000L))
                .dailyLimit(BigDecimal.valueOf(1000L))
                .ownerId(1L)
                .iban(Iban.of("PL30249000053679780493680750"))
                .build();

        accounts.add(account);
    }


    @Override
    public Account getAccount(Iban iban) {
        return this.accounts.stream()
                .filter(account -> account.getIban().equals(iban))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<Account> getUserAccounts(Long ownerId) {
        return this.accounts.stream()
                .filter(account -> account.getOwnerId().equals(ownerId))
                .collect(Collectors.toList());
    }

    @Override
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    @Override
    public boolean accountBelongsToUser(Iban iban, Long userId) {
        return this.accounts.stream()
                .anyMatch(account ->
                     account.getOwnerId().equals(userId) && account.getIban().equals(iban)
                );
    }
}
