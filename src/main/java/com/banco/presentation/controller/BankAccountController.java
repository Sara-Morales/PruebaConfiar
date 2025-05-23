package com.banco.presentation.controller;

import com.banco.application.dto.account.BankAccountRequestDto;
import com.banco.application.dto.account.BankAccountResponseDto;
import com.banco.application.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createAccount(@Valid @RequestBody BankAccountRequestDto request) {
        BankAccountResponseDto response = accountService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "statusCode", 201,
                        "message", response
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponseDto> getAccountById(@PathVariable UUID id) {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BankAccountResponseDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAll());
    }
}