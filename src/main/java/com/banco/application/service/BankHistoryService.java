package com.banco.application.service;

import com.banco.application.dto.bankhistory.BankHistoryRequest;
import com.banco.application.dto.bankhistory.BankHistoryResponse;
import com.banco.domain.model.BankAccount;
import com.banco.domain.model.BankHistory;
import com.banco.domain.repository.BankAccountRepository;
import com.banco.domain.repository.BankHistoryRepository;
import com.banco.shared.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BankHistoryService {

    private final BankHistoryRepository bankHistoryRepository;
    private final BankAccountRepository bankAccountRepository;

    public BankHistoryService(BankHistoryRepository bankHistoryRepository, BankAccountRepository bankAccountRepository) {
        this.bankHistoryRepository = bankHistoryRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Transactional
    public BankHistoryResponse createBankHistory(BankHistoryRequest request) {
        BankAccount account = bankAccountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new BusinessException("Bank account does not exist"));


        if (request.getHistoryType() != 0 && request.getHistoryType() != 1) {
            throw new BusinessException("historyType must be 0 (DEBIT) or 1 (CREDIT)");
        }

        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("Amount must be greater than zero");
        }

        BigDecimal newBalance;

        if (request.getHistoryType() == 0) { // DEBIT
            newBalance = account.getAvailableBalance().subtract(request.getAmount());
            if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                throw new BusinessException("Insufficient balance for debit");
            }
        } else { // CREDIT
            newBalance = account.getAvailableBalance().add(request.getAmount());
        }

        BankHistory bankHistory = new BankHistory(
                UUID.randomUUID(),
                request.getAccountId(),
                request.getHistoryType(),
                request.getAmount(),
                LocalDateTime.now()
        );

        BankHistory savedHistory = bankHistoryRepository.save(bankHistory);

        account.setAvailableBalance(newBalance);
        bankAccountRepository.save(account);

        return mapToResponse(savedHistory);
    }

    public List<BankHistoryResponse> getAllHistories() {
        return bankHistoryRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<BankHistoryResponse> getHistoriesByAccount(UUID accountId) {
        return bankHistoryRepository.findByAccountId(accountId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private BankHistoryResponse mapToResponse(BankHistory bankHistory) {
        BankHistoryResponse response = new BankHistoryResponse();
        response.setId(bankHistory.getId());
        response.setAccountId(bankHistory.getAccountId());
        response.setAmount(bankHistory.getAmount());
        response.setHistoryType(bankHistory.getHistoryType() == 1 ? "CR" : "DB");
        response.setCreatedAt(bankHistory.getCreatedAt());
        return response;
    }
}