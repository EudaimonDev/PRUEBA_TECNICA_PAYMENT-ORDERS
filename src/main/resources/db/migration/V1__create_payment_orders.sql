/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  AustinSalguero
 * Created: Nov 19, 2025
 */
CREATE TABLE payment_orders (
    id VARCHAR(50) PRIMARY KEY,
    amount NUMERIC(10,2) NOT NULL,
    currency VARCHAR(10) NOT NULL,

    debtor_iban VARCHAR(50) NOT NULL,
    creditor_iban VARCHAR(50) NOT NULL,

    external_reference VARCHAR(100),
    remittance_information VARCHAR(255),
    requested_execution_date DATE,

    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL
);
