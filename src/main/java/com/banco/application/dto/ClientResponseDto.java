package com.banco.application.dto;

import com.banco.domain.model.Client;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClientResponseDto {

    private UUID id;
    private String identification;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static ClientResponseDto fromDomain(Client client) {
        ClientResponseDto dto = new ClientResponseDto();
        dto.id = client.getId();
        dto.identification = client.getIdentification();
        dto.name = client.getName();
        dto.createdAt = client.getCreatedAt();
        dto.updatedAt = client.getUpdatedAt();
        return dto;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}