package com.banco.application.service;

import com.banco.application.dto.account.BankAccountRequest;
import com.banco.application.dto.account.BankAccountResponse;
import com.banco.domain.model.BankAccount;
import com.banco.domain.repository.BankAccountRepository;
import com.banco.domain.repository.ClientRepository;
import com.banco.shared.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final ClientRepository clientRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository, ClientRepository clientRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.clientRepository = clientRepository;
    }

    public BankAccountResponse create(BankAccountRequest request) {
        // Validar existencia del cliente activo
        var client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new BusinessException("El cliente no existe."));

        // Validar número de cuenta único
        if (bankAccountRepository.existsByAccountNumber(request.getAccountNumber())) {
            throw new BusinessException("El número de cuenta ya está registrado.");
        }

        // Crear modelo de dominio usando constructor vacío y setters
        BankAccount account = new BankAccount();
        account.setId(UUID.randomUUID());
        account.setClientId(request.getClientId());
        account.setAccountNumber(request.getAccountNumber());
        account.setAvailableBalance(request.getAvailableBalance());
        account.setAccountType(request.getAccountType());
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());

        BankAccount saved = bankAccountRepository.save(account);

        return toResponse(saved);
    }

    public BankAccountResponse getById(UUID id) {
        return bankAccountRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("Cuenta bancaria no encontrada."));
    }

    public List<BankAccountResponse> getAll() {
        return bankAccountRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private BankAccountResponse toResponse(BankAccount account) {
        BankAccountResponse response = new BankAccountResponse();
        response.setId(account.getId());
        response.setClientId(account.getClientId());
        response.setAccountNumber(account.getAccountNumber());
        response.setAvailableBalance(account.getAvailableBalance());
        response.setAccountType(account.getAccountType() == 1 ? "CRÉDITO" : "DÉBITO");
        response.setCreatedAt(account.getCreatedAt());
        response.setUpdatedAt(account.getUpdatedAt());
        return response;
    }
}