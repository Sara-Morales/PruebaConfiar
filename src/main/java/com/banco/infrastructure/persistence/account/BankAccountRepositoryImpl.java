package com.banco.infrastructure.persistence.account;

import com.banco.domain.model.BankAccount;
import com.banco.domain.repository.BankAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

    private final BankAccountJpaRepository jpaRepository;

    public BankAccountRepositoryImpl(BankAccountJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public BankAccount save(BankAccount account) {
        BankAccountEntity entity = toEntity(account);
        BankAccountEntity saved = jpaRepository.save(entity);
        return toModel(saved);
    }

    @Override
    public Optional<BankAccount> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toModel);
    }

    @Override
    public Optional<BankAccount> findByAccountNumber(long accountNumber) {
        return jpaRepository.findByAccountNumber(accountNumber).map(this::toModel);
    }

    @Override
    public List<BankAccount> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByAccountNumber(long accountNumber) {
        return jpaRepository.existsByAccountNumber(accountNumber);
    }

    private BankAccountEntity toEntity(BankAccount account) {
        BankAccountEntity entity = new BankAccountEntity();
        entity.setId(account.getId());
        entity.setClientId(account.getClientId());
        entity.setAccountNumber(account.getAccountNumber());
        entity.setAvailableBalance(account.getAvailableBalance());
        entity.setAccountType(account.getAccountType());
        entity.setCreatedAt(account.getCreatedAt());
        entity.setUpdatedAt(account.getUpdatedAt());
        return entity;
    }

    private BankAccount toModel(BankAccountEntity entity) {
        BankAccount model = new BankAccount();
        model.setId(entity.getId());
        model.setClientId(entity.getClientId());
        model.setAccountNumber(entity.getAccountNumber());
        model.setAvailableBalance(entity.getAvailableBalance());
        model.setAccountType(entity.getAccountType());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }
}