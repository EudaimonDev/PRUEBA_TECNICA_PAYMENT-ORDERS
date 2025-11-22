/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.payment_initiation.application;

import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import com.tuempresa.payment_initiation.domain.entity.PaymentStatus;
import com.tuempresa.payment_initiation.domain.ports.in.CreatePaymentOrderUseCase;
import com.tuempresa.payment_initiation.domain.ports.out.PaymentOrderRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author AustinSalguero
 */
public class CreatePaymentOrderUseCaseTest {

    private PaymentOrderRepository repo;
    private CreatePaymentOrderUseCase useCase;

    @BeforeEach
    void setUp() {
        repo = mock(PaymentOrderRepository.class);

        // Implementación simple del use case usando el repo mock
        useCase = order -> repo.save(order);
    }

    @Test
    void shouldPersistOrder() {
        PaymentOrder input = new PaymentOrder(
                "ID1",
                "EXT-99",
                new PaymentOrder.DebtorAccount("DEBTOR-IBAN"),
                new PaymentOrder.CreditorAccount("CREDITOR-IBAN"),
                new PaymentOrder.InstructedAmount(new BigDecimal("100.00"), "USD"),
                "Nota",
                LocalDate.now(),
                PaymentStatus.PENDING,
                OffsetDateTime.now()
        );

        // Definimos qué devuelve el repo mock
        when(repo.save(any(PaymentOrder.class))).thenReturn(input);

        // Ejecutamos el use case
        PaymentOrder result = useCase.create(input);

        // Verificaciones
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo("ID1");
        assertThat(result.getDebtorAccount().getIban()).isEqualTo("DEBTOR-IBAN");
        assertThat(result.getCreditorAccount().getIban()).isEqualTo("CREDITOR-IBAN");
        assertThat(result.getInstructedAmount().getAmount()).isEqualByComparingTo("100.00");
        assertThat(result.getInstructedAmount().getCurrency()).isEqualTo("USD");
        assertThat(result.getStatus()).isEqualTo(PaymentStatus.PENDING);

        // Verificar que se llamó al repo
        verify(repo, times(1)).save(any(PaymentOrder.class));
    }
}