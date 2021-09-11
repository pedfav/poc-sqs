package com.pedfav.pocsqs.gateway.sqs;

import com.pedfav.pocsqs.entity.IncomingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class EventListener {

    @SqsListener(value = "${localstack.sqs.incoming-event}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    private void consumer(IncomingEvent event, @Headers Map<String, String> headers, Acknowledgment ack) {
        ack.acknowledge();
        log.info("Receive message={}", event);
    }
}
