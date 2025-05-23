package com.banco.application.dto.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccountRequestDto {

    @Schema(description = "ID del cliente asociado a la cuenta", example = "123e4567-e89b-12d3-a456-426614174000", required = true)
    @NotNull(message = "El clientId es obligatorio.")
    private UUID clientId;

    @Schema(description = "Número único de la cuenta bancaria", example = "1234567890", required = true)
    @NotNull(message = "El número de cuenta es obligatorio.")
    @Min(value = 1, message = "El número de cuenta debe ser mayor a 0.")
    @Max(value = 9999999999L, message = "El número de cuenta debe tener como máximo 10 dígitos.")
    private Long accountNumber;

    @Schema(description = "Saldo disponible en la cuenta", example = "1000.50", required = true)
    @NotNull(message = "El saldo disponible es obligatorio.")
    @DecimalMin(value = "0.0", inclusive = true, message = "El saldo disponible no puede ser negativo.")
    private BigDecimal availableBalance;

    @Schema(description = "Tipo de cuenta: 1 (CRÉDITO), 2 (DÉBITO)", example = "1", required = true)
    @NotNull(message = "El tipo de cuenta es obligatorio.")
    @Min(value = 1, message = "El tipo de cuenta solo puede ser 1 (CRÉDITO) o 2 (DÉBITO).")
    @Max(value = 2, message = "El tipo de cuenta solo puede ser 1 (CRÉDITO) o 2 (DÉBITO).")
    private Integer accountType;

    // Getters y setters
    public UUID getClientId() { return clientId; }
    public void setClientId(UUID clientId) { this.clientId = clientId; }

    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }

    public BigDecimal getAvailableBalance() { return availableBalance; }
    public void setAvailableBalance(BigDecimal availableBalance) { this.availableBalance = availableBalance; }

    public Integer getAccountType() { return accountType; }
    public void setAccountType(Integer accountType) { this.accountType = accountType; }
}
