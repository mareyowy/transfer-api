package com.marey.transferapi.account.model;


import com.marey.transferapi.transfer.model.Iban;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Account implements Serializable {

    private String accountName;

    private BigDecimal balance;

    private BigDecimal availableFunds;

    private BigDecimal limit;

    private Long ownerId;

    private Iban iban;
}
