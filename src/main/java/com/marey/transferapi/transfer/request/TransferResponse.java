package com.marey.transferapi.transfer.request;


import com.marey.transferapi.transfer.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class TransferResponse {

    private Transfer transfer;

    private TransferResponseStatus responseStatus;

    public static TransferResponse of(TransferResponseStatus responseStatus) {
        return TransferResponse.of(null, responseStatus);
    }

}
