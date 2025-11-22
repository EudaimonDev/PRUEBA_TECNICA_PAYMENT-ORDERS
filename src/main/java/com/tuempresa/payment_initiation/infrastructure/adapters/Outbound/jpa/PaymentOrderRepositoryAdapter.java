package com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa;

import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import com.tuempresa.payment_initiation.domain.ports.out.PaymentOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class PaymentOrderRepositoryAdapter implements PaymentOrderRepository {

    private final PaymentOrderJpaRepository jpa;
    private final com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa.PaymentOrderMapper mapper = PaymentOrderMapper.INSTANCE;

    @Override
    public PaymentOrder save(PaymentOrder po) {
        PaymentOrderJpaEntity entity = mapper.toEntity(po);
        jpa.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public PaymentOrder findById(String id) {
        return jpa.findById(id).map(mapper::toDomain).orElse(null);
    }
}