package com.banco.application.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClientRequestDto {

    @Schema(description = "Número de identificación del cliente (solo números, máximo 12 dígitos)", example = "123456789")
    @NotBlank(message = "La identificación es obligatoria.")
    @Pattern(regexp = "\\d+", message = "La identificación solo debe contener números positivos sin signos.")
    @Size(min = 1, max = 12, message = "La identificación debe tener máximo 12 dígitos.")
    private String identification;

    @Schema(description = "Nombre completo del cliente (solo letras y espacios, entre 3 y 30 caracteres)", example = "Sara Morales")
    @NotBlank(message = "El nombre es obligatorio.")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$", message = "El nombre solo puede contener letras y espacios.")
    @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres.")
    private String name;

    // Getters y setters
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
