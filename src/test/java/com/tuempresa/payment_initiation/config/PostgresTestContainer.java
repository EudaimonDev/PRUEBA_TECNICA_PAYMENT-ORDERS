/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.payment_initiation.config;

import org.testcontainers.containers.PostgreSQLContainer;
/**
 *
 * @author AustinSalguero
 */
public class PostgresTestContainer extends PostgreSQLContainer<PostgresTestContainer> {
    private static final String IMAGE = "postgres:15";

    private static PostgresTestContainer container;

    private PostgresTestContainer() {
        super(IMAGE);
    }

    public static PostgresTestContainer getInstance() {
        if (container == null) {
            container = new PostgresTestContainer();
            container.start();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.username", container.getUsername());
        System.setProperty("spring.datasource.password", container.getPassword());
    }

    @Override
    public void stop() {}
}

