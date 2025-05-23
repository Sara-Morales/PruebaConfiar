package com.banco.infrastructure.persistence.client;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clients", uniqueConstraints = @UniqueConstraint(columnNames = "identification"))
public class ClientEntity {
    @Id
    private UUID id;

    @Column(nullable = false, unique = true, length = 12)
    private String identification;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private boolean active;  // <-- Agregado el campo active

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Getters y setters

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

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

    public boolean isActive() {    // Getter para boolean se recomienda usar "is"
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
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