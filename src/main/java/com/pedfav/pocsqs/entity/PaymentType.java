package com.pedfav.pocsqs.entity;

import com.amazonaws.util.StringUtils;
import com.pedfav.pocsqs.usecases.ProcessPayment;
import com.pedfav.pocsqs.usecases.impl.ProcessPaymentCreditImpl;
import com.pedfav.pocsqs.usecases.impl.ProcessPaymentDebitImpl;
import com.pedfav.pocsqs.usecases.impl.ProcessPaymentPixImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum PaymentType {
    DEBIT(ProcessPaymentDebitImpl.class),
    CREDIT(ProcessPaymentCreditImpl.class),
    PIX(ProcessPaymentPixImpl.class);

    private Class<? extends ProcessPayment> processClass;

    public static Optional<PaymentType> get(final String value) {
        final String paymentType = Optional.ofNullable(value).orElse("");
        return Arrays.stream(PaymentType.values())
                .filter(payment -> payment.name().equals(paymentType.toUpperCase())).findFirst();
    }
}
