package com.banco.application.dto.bankhistory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BankHistoryResponse {

    private UUID id;
    private UUID accountId;
    private String historyType; // "CR" or "DB"
    private BigDecimal amount;
    private LocalDateTime createdAt;

    // Getters and setters

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public String getHistoryType() { return historyType; }
    public void setHistoryType(String historyType) { this.historyType = historyType; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}