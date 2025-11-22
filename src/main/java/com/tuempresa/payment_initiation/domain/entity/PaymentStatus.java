    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.payment_initiation.domain.entity;

import lombok.Data;

/**
 *
 * @author AustinSalguero
 */

public enum PaymentStatus {
    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED
}
