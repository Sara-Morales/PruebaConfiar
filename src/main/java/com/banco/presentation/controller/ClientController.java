package com.banco.presentation.controller;


import com.banco.application.dto.client.ClientRequestDto;
import com.banco.application.service.ClientService;
import com.banco.domain.model.Client;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createClient(@RequestBody @Valid ClientRequestDto request) {
        Client client = service.createClient(request);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("statusCode", 201);
        response.put("message", client);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(service.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getClientById(id));
    }
}