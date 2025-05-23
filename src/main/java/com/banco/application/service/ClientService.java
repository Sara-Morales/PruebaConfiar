package com.banco.application.service;


import com.banco.application.dto.client.ClientRequestDto;
import com.banco.domain.model.Client;
import com.banco.domain.repository.ClientRepository;
import com.banco.shared.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(ClientRequestDto request) {
        String cleanId = request.getIdentification().replaceFirst("^0+", "").trim();
        if (clientRepository.findByIdentification(cleanId).isPresent()) {
            throw new BusinessException("Ya existe un cliente con esa identificación");
        }

        Client client = new Client(
                UUID.randomUUID(),
                cleanId,
                request.getName().trim(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        return clientRepository.save(client);
    }


    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente no encontrado"));
    }
}