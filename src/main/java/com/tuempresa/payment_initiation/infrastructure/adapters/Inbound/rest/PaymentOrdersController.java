package com.tuempresa.payment_initiation.infrastructure.adapters.inbound.rest;

import com.tuempresa.payment_initiation.api.PaymentOrdersApi;
import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import com.tuempresa.payment_initiation.domain.entity.PaymentStatus;
import com.tuempresa.payment_initiation.domain.ports.in.CreatePaymentOrderUseCase;
import com.tuempresa.payment_initiation.domain.ports.in.GetPaymentOrderStatusUseCase;
import com.tuempresa.payment_initiation.domain.ports.in.GetPaymentOrderUseCase;
import com.tuempresa.payment_initiation.model.PaymentOrderRequest;
import com.tuempresa.payment_initiation.model.PaymentOrderResponse;
import com.tuempresa.payment_initiation.model.PaymentStatusResponse;
import com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa.PaymentOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PaymentOrdersController implements PaymentOrdersApi {

    private final CreatePaymentOrderUseCase createUseCase;
    private final GetPaymentOrderUseCase getUseCase;
    private final GetPaymentOrderStatusUseCase statusUseCase;

    @Override
    public ResponseEntity<PaymentOrderResponse> createPaymentOrder(PaymentOrderRequest  request) {
        String id = UUID.randomUUID().toString();
        PaymentOrder domain = PaymentOrderMapper.INSTANCE.toDomain(request, id);
        PaymentOrder saved = createUseCase.create(domain);
        PaymentOrderResponse resp = PaymentOrderMapper.INSTANCE.toResponse(saved);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PaymentOrderResponse> getPaymentOrder(String paymentOrderId) {
        PaymentOrder po = getUseCase.getById(paymentOrderId);
        if (po == null) return ResponseEntity.notFound().build();
        PaymentOrderResponse resp = PaymentOrderMapper.INSTANCE.toResponse(po);
        return ResponseEntity.ok(resp);
    }

    @Override
    public ResponseEntity<PaymentStatusResponse> getPaymentOrderStatus(String paymentOrderId) {
        PaymentStatus status = statusUseCase.getStatus(paymentOrderId);
        if (status == null) return ResponseEntity.notFound().build();
        PaymentStatusResponse res = new PaymentStatusResponse();
        res.setId(paymentOrderId);
        res.setStatus(PaymentStatusResponse.StatusEnum.valueOf(status.name()));        
        res.setLastUpdated(OffsetDateTime.now());
        return ResponseEntity.ok(res);
    }

 
}