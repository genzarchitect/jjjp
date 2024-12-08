package com.stackroute.paymentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Document
public class PaymentDetails {

    @Id
    private String paymentId;  // Matches the 'id' from the Razorpay response
    private Double amount;
    private String currency;
    private String status;
    private String orderId;
    private String paymentMethod;
    private String customerEmail;
    private String customerName;
    private Instant paymentCreatedAt;
    private LocalDateTime transactionTime;

    public PaymentDetails() {
    }

    public PaymentDetails(String paymentId, Double amount, String currency, String status, String orderId, String paymentMethod, String customerEmail, String customerName, Instant paymentCreatedAt, LocalDateTime transactionTime) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.paymentCreatedAt = paymentCreatedAt;
        this.transactionTime = transactionTime;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Instant getPaymentCreatedAt() {
        return paymentCreatedAt;
    }

    public void setPaymentCreatedAt(Instant paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", orderId='" + orderId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                ", paymentCreatedAt=" + paymentCreatedAt +
                ", transactionTime=" + transactionTime +
                '}';
    }
}