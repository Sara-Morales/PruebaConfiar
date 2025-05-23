package com.banco.infrastructure.persistence.bankhistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BankHistoryJpaRepository extends JpaRepository<BankHistoryEntity, UUID> {
    List<BankHistoryEntity> findByAccountId(UUID accountId);
}