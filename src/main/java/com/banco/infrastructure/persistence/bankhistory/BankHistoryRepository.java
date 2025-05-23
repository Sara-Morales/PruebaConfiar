package com.banco.infrastructure.persistence.bankhistory;

import com.banco.domain.model.BankHistory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class BankHistoryRepository implements com.banco.domain.repository.BankHistoryRepository {

    private final BankHistoryJpaRepository bankHistoryJpaRepository;

    public BankHistoryRepository(BankHistoryJpaRepository bankHistoryJpaRepository) {
        this.bankHistoryJpaRepository = bankHistoryJpaRepository;
    }

    @Override
    @Transactional
    public BankHistory save(BankHistory bankHistory) {
        BankHistoryEntity entity = toEntity(bankHistory);
        BankHistoryEntity savedEntity = bankHistoryJpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<BankHistory> findById(UUID id) {
        return bankHistoryJpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<BankHistory> findAll() {
        return bankHistoryJpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<BankHistory> findByAccountId(UUID accountId) {
        return bankHistoryJpaRepository.findByAccountId(accountId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private BankHistoryEntity toEntity(BankHistory bankHistory) {
        BankHistoryEntity entity = new BankHistoryEntity();
        entity.setId(bankHistory.getId());
        entity.setAccountId(bankHistory.getAccountId());
        entity.setHistoryType(bankHistory.getHistoryType());
        entity.setAmount(bankHistory.getAmount());
        entity.setCreatedAt(bankHistory.getCreatedAt());
        return entity;
    }

    private BankHistory toDomain(BankHistoryEntity entity) {
        return new BankHistory(
                entity.getId(),
                entity.getAccountId(),
                entity.getHistoryType(),
                entity.getAmount(),
                entity.getCreatedAt()
        );
    }
}