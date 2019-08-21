package com.usl.microservices.sampleeventsourcing.kafka.deliverer;

import com.usl.microservices.sampleeventsourcing.kafka.stream.EventStream;
import com.usl.microservices.sampleeventsourcing.persistence.model.ProcessEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.UUID;

@Component
public class InsuranceEventDeliverer {

    private static final Logger logger = LoggerFactory.getLogger(InsuranceEventDeliverer.class);

    private EventStream stream;

    @Autowired
    public InsuranceEventDeliverer(EventStream stream) {
        this.stream = stream;
    }

    public void pubhishEvent(String eventBody) {
        logger.debug("Sending Kafka message for insurance event: {}", eventBody);

        stream.outboundCatalogLookup().send(MessageBuilder
                .withPayload(eventBody)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    }

}
