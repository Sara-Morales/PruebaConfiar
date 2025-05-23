package com.banco.domain.repository;

import com.banco.domain.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankAccountRepository {
    BankAccount save(BankAccount account);
    Optional<BankAccount> findById(UUID id);
    Optional<BankAccount> findByAccountNumber(long accountNumber);
    List<BankAccount> findAll();

    boolean existsByAccountNumber(long accountNumber);
}