package com.pedfav.pocsqs.entity;

import com.pedfav.pocsqs.usecases.ProcessPayment;
import com.pedfav.pocsqs.usecases.impl.ProcessPaymentCreditImpl;
import com.pedfav.pocsqs.usecases.impl.ProcessPaymentDebitImpl;
import com.pedfav.pocsqs.usecases.impl.ProcessPaymentPixImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    DEBIT(ProcessPaymentDebitImpl.class),
    CREDIT(ProcessPaymentCreditImpl.class),
    PIX(ProcessPaymentPixImpl.class);

    private Class<? extends ProcessPayment> processClass;
}
