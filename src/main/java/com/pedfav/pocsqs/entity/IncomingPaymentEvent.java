package com.pedfav.pocsqs.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IncomingPaymentEvent {

    private String paymentId;
    private PaymentType paymentType;
    private double value;

}
