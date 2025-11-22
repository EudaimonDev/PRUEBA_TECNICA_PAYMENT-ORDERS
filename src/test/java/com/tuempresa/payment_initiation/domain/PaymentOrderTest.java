/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.payment_initiation.domain;

import com.tuempresa.payment_initiation.domain.entity.PaymentOrder;
import com.tuempresa.payment_initiation.domain.entity.PaymentOrder.CreditorAccount;
import com.tuempresa.payment_initiation.domain.entity.PaymentOrder.DebtorAccount;
import com.tuempresa.payment_initiation.domain.entity.PaymentOrder.InstructedAmount;
import com.tuempresa.payment_initiation.domain.entity.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 *
 * @author AustinSalguero
 */
public class PaymentOrderTest {
@Test
void shouldCreatePaymentOrderSuccessfully() {
    PaymentOrder order = new PaymentOrder(
            "123",
            "EXT-1",
            new DebtorAccount("DEBTOR-IBAN"),
            new CreditorAccount("CREDITOR-IBAN"),
            new InstructedAmount(new BigDecimal("150.75"), "USD"),
            "Factura",
            LocalDate.parse("2025-10-31"),
            PaymentStatus.PENDING,
            OffsetDateTime.now()
    );

    assertThat(order.getId()).isEqualTo("123");
    assertThat(order.getDebtorAccount().getIban()).isEqualTo("DEBTOR-IBAN");
    assertThat(order.getCreditorAccount().getIban()).isEqualTo("CREDITOR-IBAN");
    assertThat(order.getInstructedAmount().getAmount()).isEqualByComparingTo("150.75");
    assertThat(order.getInstructedAmount().getCurrency()).isEqualTo("USD");
    assertThat(order.getStatus()).isEqualTo(PaymentStatus.PENDING);
}
}
