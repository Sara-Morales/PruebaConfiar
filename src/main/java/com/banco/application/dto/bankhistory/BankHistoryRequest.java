package com.banco.application.dto.bankhistory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

public class BankHistoryRequest {

    @Schema(description = "ID de la cuenta bancaria asociada al movimiento", example = "123e4567-e89b-12d3-a456-426614174000", required = true)
    @NotNull(message = "El accountId es obligatorio")
    private UUID accountId;

    @Schema(description = "Tipo de movimiento: 1 = CRÉDITO, 0 = DÉBITO", example = "1", required = true)
    @NotNull(message = "historyType es obligatorio")
    @Min(value = 0, message = "historyType debe ser 1 = CRÉDITO, 0 = DÉBITO")
    @Max(value = 1, message = "historyType debe ser 1 = CRÉDITO, 0 = DÉBITO")
    private Integer historyType;

    @Schema(description = "Monto del movimiento, debe ser mayor que 0", example = "500.00", required = true)
    @NotNull(message = "amount es obligatorio")
    @DecimalMin(value = "0.01", inclusive = true, message = "El amount debe ser mayor que 0")
    private BigDecimal amount;

    // Getters y setters

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public Integer getHistoryType() { return historyType; }
    public void setHistoryType(Integer historyType) { this.historyType = historyType; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
