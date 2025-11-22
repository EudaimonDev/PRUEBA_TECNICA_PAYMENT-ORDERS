package com.tuempresa.payment_initiation.domain.ports.in;

import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;

public interface GetPaymentOrderUseCase {
    PaymentOrder getById(String id);
}