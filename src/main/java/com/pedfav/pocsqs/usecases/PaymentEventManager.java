package com.pedfav.pocsqs.usecases;

import com.pedfav.pocsqs.entity.PaymentType;
import com.pedfav.pocsqs.utils.SpringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEventManager {

    private final SpringUtils springUtils;

    public ProcessPayment getProcessPaymentClass(final PaymentType paymentType) {
        return springUtils.getManagedBean(paymentType.getProcessClass());
    }
}