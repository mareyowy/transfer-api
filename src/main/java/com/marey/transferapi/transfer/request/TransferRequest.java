package com.marey.transferapi.transfer.request;


import com.marey.transferapi.transfer.model.Iban;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransferRequest {

    @NotNull
    private Iban senderAccount;

    @NotNull
    private Iban recipientAccount;

    @NotNull
    @Size(min = 1, max = 25)
    private String recipientName;

    @Size(max = 250)
    private String recipientAddress;

    @Future
    @NotNull
    private LocalDateTime sendDate;

    @Digits(integer = 9, fraction = 2)
    @NotNull
    private BigDecimal amount;

    @Size(min = 1, max = 130)
    @NotNull
    private String title;

    @NotNull
    private Long userId;
}
