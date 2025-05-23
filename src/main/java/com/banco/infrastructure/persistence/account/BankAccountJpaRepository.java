package com.banco.infrastructure.persistence.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, UUID> {

    Optional<BankAccountEntity> findByAccountNumber(long accountNumber);

    boolean existsByAccountNumber(long accountNumber);
}