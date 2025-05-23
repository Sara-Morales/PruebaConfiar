package com.banco.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BankAccount {

    private UUID id;
    private UUID clientId;
    private long accountNumber;
    private BigDecimal availableBalance;
    private int accountType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BankAccount() {
    }

    // Constructor completo
    public BankAccount(UUID id, UUID clientId, long accountNumber, BigDecimal availableBalance, int accountType,
                       LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.accountType = accountType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y setters

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getClientId() {
        return clientId;
    }
    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }
    public int getAccountType() {
        return accountType;
    }
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}