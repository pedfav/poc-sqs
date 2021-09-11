package com.pedfav.pocsqs.gateway.sqs;

import com.pedfav.pocsqs.entity.Payment;
import com.pedfav.pocsqs.entity.PostProcessingEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class PostProcessingPaymentProducer {

    private final QueueMessagingTemplate messagingTemplate;

    public void send(final Payment payment) {
        log.info("Publishing payment={}", payment);
        messagingTemplate.convertAndSend("output-event", payment);
    }
}