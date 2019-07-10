package com.marey.transferapi.transfer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Transfer implements Serializable {

    private Long id;

    private String title;

    private Iban senderAccount;

    private String senderName;

    private String senderAddres;

    private Iban recipientAccount;

    private String recipientName;

    private String recipientAddress;

    private LocalDateTime sendDate;

    private BigDecimal amount;

    private BigDecimal balanceAfter;
}
