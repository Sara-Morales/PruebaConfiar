package com.banco.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BankHistory {
    private UUID id;
    private UUID accountId;
    private int historyType; // 1 = CREDIT ("CR"), 0 = DEBIT ("DB")
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public BankHistory(UUID id, UUID accountId, int historyType, BigDecimal amount, LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.historyType = historyType;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    // Getters and setters

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public int getHistoryType() { return historyType; }
    public void setHistoryType(int historyType) { this.historyType = historyType; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}