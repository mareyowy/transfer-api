package com.marey.transferapi.commons;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private Status status;

    private String errorCode;

    private String errorDescription;

    public enum Status {
        OK, ERROR
    }
}
