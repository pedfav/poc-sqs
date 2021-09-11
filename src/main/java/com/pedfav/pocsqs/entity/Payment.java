package com.pedfav.pocsqs.entity;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String paymentId;
    private String paidWith;
    private double valuePaid;
    private boolean payed;
}
