package com.marey.transferapi.account.model;


import com.marey.transferapi.transfer.model.Iban;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    private String accountName;

    private BigDecimal balance;

    private BigDecimal availableFunds;

    private BigDecimal dailyLimit;

    private Long ownerId;

    private Iban iban;
}
