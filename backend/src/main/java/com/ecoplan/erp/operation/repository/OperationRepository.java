package com.ecoplan.erp.operation.repository;

import com.ecoplan.erp.operation.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}