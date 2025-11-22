package com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderJpaRepository extends JpaRepository<PaymentOrderJpaEntity, String> {
}