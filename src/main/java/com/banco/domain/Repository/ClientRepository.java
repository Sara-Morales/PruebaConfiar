package com.banco.domain.repository;

import com.banco.domain.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    Client save(Client client);
    List<Client> findAll();
    Optional<Client> findById(UUID id);
    Optional<Client> findByIdentification(String identification);
}