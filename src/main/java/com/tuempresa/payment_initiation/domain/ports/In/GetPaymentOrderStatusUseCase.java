package com.tuempresa.payment_initiation.domain.ports.in;

import com.tuempresa.payment_initiation.domain.entity.PaymentStatus;

public interface GetPaymentOrderStatusUseCase {
    PaymentStatus getStatus(String id);
}