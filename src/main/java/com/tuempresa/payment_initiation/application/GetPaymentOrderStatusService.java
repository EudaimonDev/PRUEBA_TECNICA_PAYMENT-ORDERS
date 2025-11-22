package com.tuempresa.payment_initiation.application;

import com.tuempresa.payment_initiation.domain.ports.in.GetPaymentOrderStatusUseCase;
import com.tuempresa.payment_initiation.domain.ports.out.PaymentOrderRepository;
import com.tuempresa.payment_initiation.domain.entity.PaymentStatus;
import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPaymentOrderStatusService implements GetPaymentOrderStatusUseCase {

    private final PaymentOrderRepository repository;

    @Override
    public PaymentStatus getStatus(String id) {
        PaymentOrder po = repository.findById(id);
        if (po == null) return null;
        return po.getStatus();
    }
}