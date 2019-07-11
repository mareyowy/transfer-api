package com.marey.transferapi.transfer.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude
public class TransferRequest implements Serializable {

    @NotNull
    private String senderAccount;

    @NotNull
    private String recipientAccount;

    @NotNull
    @Size(min = 1, max = 25)
    private String recipientName;

    @Size(max = 250)
    private String recipientAddress;

    //@Digits(integer = 9, fraction = 2)
    @NotNull
    private BigDecimal amount;

    @Size(min = 1, max = 130)
    @NotNull
    private String title;

    @NotNull
    private Long userId;
}
