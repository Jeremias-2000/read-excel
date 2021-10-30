package com.test.enums;

public enum PaymentMethod {
    CREDIT_CARD("CREDIT_CARD"),
    TICKET("TICKET");

    private String code;

    PaymentMethod(String method) {
        this.code = method;
    }

    public String getCode() {
        return code;
    }
}
