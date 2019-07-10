package com.marey.transferapi.transfer.request;


import com.marey.transferapi.commons.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferResponse extends BaseResponse {

    private Long transferId;

}
