package com.test.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", code=" + code +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", method='" + method + '\'' +
                ", value=" + value +
                '}';
    }
}
