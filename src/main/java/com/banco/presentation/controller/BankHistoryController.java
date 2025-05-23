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
@RequestMapping("/api/bankhistory")
@Tag(name = "BankHistory", description = "Bank History (Transactions) API")
public class BankHistoryController {

    private final BankHistoryService bankHistoryService;

    public BankHistoryController(BankHistoryService bankHistoryService) {
        this.bankHistoryService = bankHistoryService;
    }

    @Operation(summary = "Create a bank history (transaction)")
    @PostMapping
    public ResponseEntity<BankHistoryResponse> createBankHistory(@Valid @RequestBody BankHistoryRequest request) {
        BankHistoryResponse response = bankHistoryService.createBankHistory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get all bank histories")
    @GetMapping
    public ResponseEntity<List<BankHistoryResponse>> getAllBankHistories() {
        List<BankHistoryResponse> responses = bankHistoryService.getAllHistories();
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Get bank histories by account id")
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<BankHistoryResponse>> getBankHistoriesByAccount(@PathVariable UUID accountId) {
        List<BankHistoryResponse> responses = bankHistoryService.getHistoriesByAccount(accountId);
        return ResponseEntity.ok(responses);
    }
}