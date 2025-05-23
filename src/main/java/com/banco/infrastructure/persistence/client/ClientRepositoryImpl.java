package com.banco.infrastructure.persistence.client;

import com.banco.domain.model.Client;
import com.banco.domain.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientJpaRepository jpaRepository;

    public ClientRepositoryImpl(ClientJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Client save(Client client) {
        ClientEntity entity = toEntity(client);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public List<Client> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Client> findByIdentification(String identification) {
        return jpaRepository.findByIdentification(identification).map(this::toDomain);
    }

    private Client toDomain(ClientEntity entity) {
        return new Client(
                entity.getId(),
                entity.getIdentification(),
                entity.getName(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private ClientEntity toEntity(Client client) {
        ClientEntity entity = new ClientEntity();
        entity.setId(client.getId());
        entity.setIdentification(client.getIdentification());
        entity.setName(client.getName());
        entity.setCreatedAt(client.getCreatedAt());
        entity.setUpdatedAt(client.getUpdatedAt());
        return entity;
    }
}