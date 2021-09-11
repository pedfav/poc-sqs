package com.pedfav.pocsqs.gateway.sqs;

import com.pedfav.pocsqs.entity.IncomingEvent;
import com.pedfav.pocsqs.entity.OutputEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class EventListener {

    private final OutputEventProducer producer;

    @SqsListener(value = "${localstack.sqs.incoming-event}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    private void consumerIncomingEvent(IncomingEvent event, @Headers Map<String, String> headers, Acknowledgment ack) {
        log.info("Received message - incoming-event={} with headers={}", event, headers);
        OutputEvent outputEvent = OutputEvent.builder().message(event.getMessage()).build();
        producer.send(outputEvent);
        ack.acknowledge();
    }

    @SqsListener(value = "${localstack.sqs.output-event}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    private void consumerOutputEvent(OutputEvent event, @Headers Map<String, String> headers, Acknowledgment ack) {
        log.info("Received message - output-event={} with headers={}", event, headers);
        ack.acknowledge();
    }
}
