package com.banco.application.dto.bankhistory;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

public class BankHistoryRequest {

    @NotNull(message = "El accountId es obligatorio")
    private UUID accountId;

    @NotNull(message = "historyType es obligatorio")
    @Min(value = 0, message = "historyType debe ser 1 = CRÉDITO, 0 = DÉBITO")
    @Max(value = 1, message = "historyType debe ser 1 = CRÉDITO, 0 = DÉBITO")
    private Integer historyType;

    @NotNull(message = "amount es obligatorio")
    @DecimalMin(value = "0.01", inclusive = true, message = "El amount debe ser mayor que 0")
    private BigDecimal amount;

    // Getters and setters

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public Integer getHistoryType() { return historyType; }
    public void setHistoryType(Integer historyType) { this.historyType = historyType; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}