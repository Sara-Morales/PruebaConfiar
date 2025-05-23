package com.banco.presentation.controller;

import com.banco.application.dto.account.BankAccountRequestDto;
import com.banco.application.dto.account.BankAccountResponseDto;
import com.banco.application.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/cuentas")
@Tag(name = "CuentaBancaria", description = "API para la gestión de cuentas bancarias")
public class BankAccountController {

    private final BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Crear una nueva cuenta bancaria")
    @PostMapping
    public ResponseEntity<Map<String, Object>> crearCuenta(@Valid @RequestBody BankAccountRequestDto request) {
        BankAccountResponseDto response = accountService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "codigoEstado", 201,
                        "mensaje", response
                ));
    }

    @Operation(summary = "Obtener cuenta bancaria por ID")
    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponseDto> obtenerCuentaPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @Operation(summary = "Obtener todas las cuentas bancarias")
    @GetMapping
    public ResponseEntity<List<BankAccountResponseDto>> obtenerTodasLasCuentas() {
        return ResponseEntity.ok(accountService.getAll());
    }
}
