package com.banco.presentation.controller;

import com.banco.application.dto.client.ClientRequestDto;
import com.banco.application.service.ClientService;
import com.banco.domain.model.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clientes", description = "Operaciones para gestionar clientes")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Crea un cliente nuevo en el sistema con identificación y nombre válidos."
    )
    public ResponseEntity<Map<String, Object>> createClient(@RequestBody @Valid ClientRequestDto request) {
        Client client = service.createClient(request);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("statusCode", 201);
        response.put("message", client);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    @Operation(summary = "Listar todos los clientes", description = "Obtiene una lista con todos los clientes registrados.")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(service.getAllClients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar cliente por ID", description = "Obtiene la información de un cliente dado su ID.")
    public ResponseEntity<Client> getClientById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getClientById(id));
    }
}
