package com.tuempresa.payment_initiation.application;

import com.tuempresa.payment_initiation.domain.ports.in.CreatePaymentOrderUseCase;
import com.tuempresa.payment_initiation.domain.ports.out.PaymentOrderRepository;
import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePaymentOrderService implements CreatePaymentOrderUseCase {

    private final PaymentOrderRepository repository;

    @Override
    public PaymentOrder create(PaymentOrder order) {
        return repository.save(order);
    }
}