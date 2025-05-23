package com.banco.domain.repository;

import com.banco.domain.model.BankHistory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankHistoryRepository {
    BankHistory save(BankHistory bankHistory);
    Optional<BankHistory> findById(UUID id);
    List<BankHistory> findAll();
    List<BankHistory> findByAccountId(UUID accountId);
}