package com.pedfav.pocsqs.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IncomingPaymentEvent {

    private String paymentId;
    private String paymentType;
    private double value;

}
