package com.pedfav.pocsqs.gateway.sqs;

import com.pedfav.pocsqs.entity.IncomingPaymentEvent;
import com.pedfav.pocsqs.entity.Payment;
import com.pedfav.pocsqs.entity.PaymentType;
import com.pedfav.pocsqs.entity.PostProcessingEvent;
import com.pedfav.pocsqs.exceptions.PaymentNotSupportedException;
import com.pedfav.pocsqs.usecases.PaymentEventManager;
import com.pedfav.pocsqs.usecases.ProcessPayment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class EventListener {

    private final PostProcessingPaymentProducer producer;
    private final PaymentEventManager paymentEventManager;

    @SqsListener(value = "${localstack.sqs.incoming-event}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    private void consumerIncomingEvent(IncomingPaymentEvent event, @Headers Map<String, String> headers, Acknowledgment ack) {
        log.info("Received message - incoming-event={} with headers={}", event, headers);
        try {
            PaymentType paymentType = PaymentType.get(event.getPaymentType())
                    .orElseThrow(PaymentNotSupportedException::new);

            ProcessPayment processPayment = paymentEventManager.getProcessPaymentClass(paymentType);
            Payment payment = processPayment.pay(event);
            producer.send(payment);
        } catch(Exception e) {
            log.error("Error on payment process");
        } finally {
            ack.acknowledge();
        }
    }

    @SqsListener(value = "${localstack.sqs.output-event}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    private void consumerOutputEvent(Payment payment, @Headers Map<String, String> headers, Acknowledgment ack) {
        log.info("Received payment - output-event={} with headers={}", payment, headers);
        ack.acknowledge();
    }
}
