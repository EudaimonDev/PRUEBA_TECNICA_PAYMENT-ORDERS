
package com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa;

import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import com.tuempresa.payment_initiation.model.PaymentOrderRequest;
import com.tuempresa.payment_initiation.model.PaymentOrderResponse;
import com.tuempresa.payment_initiation.model.DebtorAccount;
import com.tuempresa.payment_initiation.model.CreditorAccount;
import com.tuempresa.payment_initiation.model.InstructedAmount;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * Simple mapper (no external libs). Use static INSTANCE for convenience.
 */
public class PaymentOrderMapper {

    public static final PaymentOrderMapper INSTANCE = new PaymentOrderMapper();

    private PaymentOrderMapper() {}

    // DTO request -> Domain
    public PaymentOrder toDomain(PaymentOrderRequest  req, String id) {
        return new PaymentOrder(
                id,
                req.getExternalReference(),
                new PaymentOrder.DebtorAccount(req.getDebtorAccount().getIban()),
                new PaymentOrder.CreditorAccount(req.getCreditorAccount().getIban()),
                new PaymentOrder.InstructedAmount(req.getInstructedAmount().getAmount(), req.getInstructedAmount().getCurrency()),
                req.getRemittanceInformation(),
                req.getRequestedExecutionDate() != null ? LocalDate.parse(req.getRequestedExecutionDate().toString()) : null,
                com.tuempresa.payment_initiation.domain.entity.PaymentStatus.PENDING,
                OffsetDateTime.now()
        );
    }

    // Domain -> JPA entity
    public PaymentOrderJpaEntity toEntity(PaymentOrder domain) {
        PaymentOrderJpaEntity e = new PaymentOrderJpaEntity();
        e.setId(domain.getId());
        e.setExternalReference(domain.getExternalReference());
        e.setDebtorIban(domain.getDebtorAccount().getIban());
        e.setCreditorIban(domain.getCreditorAccount().getIban());
        e.setAmount(domain.getInstructedAmount().getAmount());
        e.setCurrency(domain.getInstructedAmount().getCurrency());
        e.setRemittanceInformation(domain.getRemittanceInformation());
        e.setRequestedExecutionDate(domain.getRequestedExecutionDate());
        e.setStatus(domain.getStatus().name());
        e.setCreatedAt(domain.getCreatedAt());
        return e;
    }

    // JPA entity -> Domain
    public PaymentOrder toDomain(PaymentOrderJpaEntity e) {
        return new PaymentOrder(
                e.getId(),
                e.getExternalReference(),
                new PaymentOrder.DebtorAccount(e.getDebtorIban()),
                new PaymentOrder.CreditorAccount(e.getCreditorIban()),
                new PaymentOrder.InstructedAmount(e.getAmount(), e.getCurrency()),
                e.getRemittanceInformation(),
                e.getRequestedExecutionDate(),
                com.tuempresa.payment_initiation.domain.entity.PaymentStatus.valueOf(e.getStatus()),
                e.getCreatedAt()
        );
    }

    // Domain -> DTO Response
    public PaymentOrderResponse toResponse(PaymentOrder domain) {
        PaymentOrderResponse resp = new PaymentOrderResponse();
        resp.setId(domain.getId());
        resp.setExternalReference(domain.getExternalReference());

        DebtorAccount da = new DebtorAccount();
        da.setIban(domain.getDebtorAccount().getIban());
        resp.setDebtorAccount(da);

        CreditorAccount ca = new CreditorAccount();
        ca.setIban(domain.getCreditorAccount().getIban());
        resp.setCreditorAccount(ca);

        InstructedAmount ia = new InstructedAmount();
        ia.setAmount(domain.getInstructedAmount().getAmount());
        ia.setCurrency(domain.getInstructedAmount().getCurrency());
        resp.setInstructedAmount(ia);

        resp.setRemittanceInformation(domain.getRemittanceInformation());
        resp.setRequestedExecutionDate(domain.getRequestedExecutionDate());
        resp.setStatus(PaymentOrderResponse.StatusEnum.valueOf(domain.getStatus().name()));
        resp.setCreatedAt(domain.getCreatedAt());
        return resp;
    }
}