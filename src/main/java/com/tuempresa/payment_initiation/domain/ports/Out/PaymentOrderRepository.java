package com.tuempresa.payment_initiation.domain.ports.out;

import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;

public interface PaymentOrderRepository {
    PaymentOrder save(PaymentOrder order);
    PaymentOrder findById(String id);
}