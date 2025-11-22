package com.tuempresa.payment_initiation.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Data;

import lombok.Data;

/**
 * Domain PaymentOrder — estructura igual al JSON del banco (objetos anidados).
 */
@Data
public class PaymentOrder {

    private final String id;
    private final String externalReference;
    private final DebtorAccount debtorAccount;
    private final CreditorAccount creditorAccount;
    private final InstructedAmount instructedAmount;
    private final String remittanceInformation;
    private final LocalDate requestedExecutionDate;
    private final PaymentStatus status;
    private final OffsetDateTime createdAt;

    public PaymentOrder(
            String id,
            String externalReference,
            DebtorAccount debtorAccount,
            CreditorAccount creditorAccount,
            InstructedAmount instructedAmount,
            String remittanceInformation,
            LocalDate requestedExecutionDate,
            PaymentStatus status,
            OffsetDateTime createdAt
    ) {
        this.id = id;
        this.externalReference = externalReference;
        this.debtorAccount = debtorAccount;
        this.creditorAccount = creditorAccount;
        this.instructedAmount = instructedAmount;
        this.remittanceInformation = remittanceInformation;
        this.requestedExecutionDate = requestedExecutionDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Data
    public static class DebtorAccount {
        private final String iban;
        public DebtorAccount(String iban) { this.iban = iban; }
    }

    @Data
    public static class CreditorAccount {
        private final String iban;
        public CreditorAccount(String iban) { this.iban = iban; }
    }

    @Data
    public static class InstructedAmount {
        private final BigDecimal amount;
        private final String currency;
        public InstructedAmount(BigDecimal amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }
    }
}