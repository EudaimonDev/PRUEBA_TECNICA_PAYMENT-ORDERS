package com.tuempresa.payment_initiation.application;

import com.tuempresa.payment_initiation.domain.ports.in.GetPaymentOrderUseCase;
import com.tuempresa.payment_initiation.domain.ports.out.PaymentOrderRepository;
import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPaymentOrderService implements GetPaymentOrderUseCase {

    private final com.tuempresa.payment_initiation.domain.ports.out.PaymentOrderRepository repository;

    @Override
    public PaymentOrder getById(String id) {
        return repository.findById(id);
    }
}