package com.prices.exception;

import lombok.Data;

@Data
public class ExResponse extends RuntimeException{

    private int errCode;
    public ExResponse(String msg, int errCode, Exception e) {
        super(msg, e);
        this.errCode = errCode;
    }


}
