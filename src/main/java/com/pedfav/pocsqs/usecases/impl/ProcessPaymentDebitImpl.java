package com.pedfav.pocsqs.usecases.impl;

import com.pedfav.pocsqs.entity.IncomingPaymentEvent;
import com.pedfav.pocsqs.entity.Payment;
import com.pedfav.pocsqs.usecases.ProcessPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProcessPaymentDebitImpl implements ProcessPayment {

    @Override
    public Payment pay(IncomingPaymentEvent event) {
        log.info("Executing payment with Debit card");
        return Payment.builder()
                .paymentId(event.getPaymentId())
                .valuePaid(event.getValue())
                .paidWith(event.getPaymentType().toString())
                .payed(true)
                .build();
    }
}