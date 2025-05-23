package com.banco.presentation.controller;

import com.banco.application.dto.bankhistory.BankHistoryRequest;
import com.banco.application.dto.bankhistory.BankHistoryResponse;
import com.banco.application.service.BankHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/historialbancario")
@Tag(name = "HistorialBancario", description = "API para la gestión de movimientos bancarios")
public class BankHistoryController {

    private final BankHistoryService bankHistoryService;

    public BankHistoryController(BankHistoryService bankHistoryService) {
        this.bankHistoryService = bankHistoryService;
    }

    @Operation(summary = "Crear un movimiento bancario (historial)")
    @PostMapping
    public ResponseEntity<BankHistoryResponse> crearMovimiento(@Valid @RequestBody BankHistoryRequest request) {
        BankHistoryResponse response = bankHistoryService.createBankHistory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Obtener todos los movimientos bancarios")
    @GetMapping
    public ResponseEntity<List<BankHistoryResponse>> obtenerTodosLosMovimientos() {
        List<BankHistoryResponse> responses = bankHistoryService.getAllHistories();
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Obtener movimientos por ID de cuenta")
    @GetMapping("/cuenta/{accountId}")
    public ResponseEntity<List<BankHistoryResponse>> obtenerMovimientosPorCuenta(@PathVariable UUID accountId) {
        List<BankHistoryResponse> responses = bankHistoryService.getHistoriesByAccount(accountId);
        return ResponseEntity.ok(responses);
    }
}
