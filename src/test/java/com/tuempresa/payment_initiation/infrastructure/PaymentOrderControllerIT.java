/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.payment_initiation.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuempresa.payment_initiation.config.PostgresTestContainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 *
 * @author AustinSalguero
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentOrderControllerIT {
     @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper json;

    @BeforeAll
    static void init() {
        PostgresTestContainer.getInstance();
    }

    @Test
    void shouldCreateOrderSuccessfully() throws Exception {
        Map<String, Object> body = Map.of(
                "externalReference", "EXT-1",
                "debtorAccount", Map.of("iban", "D-IBAN"),
                "creditorAccount", Map.of("iban", "C-IBAN"),
                "instructedAmount", Map.of("amount", 100.50, "currency", "USD"),
                "remittanceInformation", "Test",
                "requestedExecutionDate", "2025-10-31"
        );

        mvc.perform(post("/payment-initiation/payment-orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.writeValueAsString(body)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.status").value("PENDING"));
    }
}
