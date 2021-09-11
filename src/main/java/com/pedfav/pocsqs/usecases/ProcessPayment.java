package com.pedfav.pocsqs.usecases;

import com.pedfav.pocsqs.entity.IncomingPaymentEvent;
import com.pedfav.pocsqs.entity.Payment;

public interface ProcessPayment {

    Payment pay(IncomingPaymentEvent event);
}
