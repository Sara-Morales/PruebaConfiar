package com.banco.application.dto.account;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccountRequestDto {

    @NotNull(message = "El clientId es obligatorio.")
    private UUID clientId;

    @NotNull(message = "El número de cuenta es obligatorio.")
    @Min(value = 1, message = "El número de cuenta debe ser mayor a 0.")
    @Max(value = 9999999999L, message = "El número de cuenta debe tener como máximo 10 dígitos.")
    private Long accountNumber;

    @NotNull(message = "El saldo disponible es obligatorio.")
    @DecimalMin(value = "0.0", inclusive = true, message = "El saldo disponible no puede ser negativo.")
    private BigDecimal availableBalance;

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