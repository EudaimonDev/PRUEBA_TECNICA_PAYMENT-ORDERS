/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.payment_initiation.infrastructure;

import com.tuempresa.payment_initiation.config.PostgresTestContainer;
import com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa.PaymentOrderJpaEntity;
import com.tuempresa.payment_initiation.infrastructure.adapters.outbound.jpa.PaymentOrderJpaRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

/**
 *
 * @author AustinSalguero
 */
@DataJpaTest
@Import(PostgresTestContainer.class)
public class PaymentOrderRepositoryIT {
    
    @Autowired
    private PaymentOrderJpaRepository repo;
    
    @BeforeAll
    static void setup(){
        PostgresTestContainer.getInstance();
    }
    
      @Test
    void shouldPersistAndFindOrder() {
        PaymentOrderJpaEntity entity = new PaymentOrderJpaEntity();
        entity.setId("ABC123");
        entity.setDebtorIban("D-IBAN");
        entity.setCreditorIban("C-IBAN");
        entity.setAmount(new BigDecimal("10.00"));
        entity.setCurrency("USD");
        entity.setStatus("PENDING");
        entity.setRequestedExecutionDate(LocalDate.now());

        repo.save(entity);

        assertThat(repo.findById("ABC123")).isPresent();
    }
    
}
