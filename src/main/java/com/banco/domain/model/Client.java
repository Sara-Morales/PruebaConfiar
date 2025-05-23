package com.banco.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Client {
    private UUID id;
    private String identification;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Client(UUID id, String identification, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}