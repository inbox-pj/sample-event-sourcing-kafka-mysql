package com.usl.microservices.sampleeventsourcing.kafka.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventStream {

    String OUTPUT = "insurance-event-out";

    @Output(OUTPUT)
    MessageChannel outboundCatalogLookup();
}
