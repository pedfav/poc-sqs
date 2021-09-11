package com.pedfav.pocsqs.gateway.sqs;

import com.pedfav.pocsqs.entity.OutputEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OutputEventProducer {

    private final QueueMessagingTemplate messagingTemplate;

    public void send(final OutputEvent event) {
        log.info("Publishing message={}", event);
        messagingTemplate.convertAndSend("output-event", event);
    }
}