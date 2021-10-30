package com.test.entity;

public class Payment {
    private long code;
    private String creditCardNumber;
    private String method;
    private double value;

    public Payment() {
    }


    public Payment(long code, String creditCardNumber, String method, double value) {
        this.code = code;
        this.creditCardNumber = creditCardNumber;
        this.method = method;
        this.value = value;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
