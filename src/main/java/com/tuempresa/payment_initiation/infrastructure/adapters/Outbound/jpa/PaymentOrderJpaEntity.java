package com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_orders")
public class PaymentOrderJpaEntity {

    @Id
    @Column(name = "id", length = 100)
    private String id;

    @Column(name = "external_reference", length = 100)
    private String externalReference;

    @Column(name = "debtor_iban", length = 100, nullable = false)
    private String debtorIban;

    @Column(name = "creditor_iban", length = 100, nullable = false)
    private String creditorIban;

    @Column(name = "amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", length = 10, nullable = false)
    private String currency;

    @Column(name = "remittance_information", length = 255)
    private String remittanceInformation;

    @Column(name = "requested_execution_date")
    private LocalDate requestedExecutionDate;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}