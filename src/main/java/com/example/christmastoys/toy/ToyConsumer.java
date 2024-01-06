package com.example.christmastoys.toy;

import com.example.christmastoys.toy.annotation.ValidateToyCreatedEvent;
import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.service.ChristmasToyRegionSelectionService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ToyConsumer {

    private final ChristmasToyRegionSelectionService service;

    @ValidateToyCreatedEvent
    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void ConsumeToyRequestCreate(@Payload String event,
                                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                        @Header(KafkaHeaders.OFFSET) int offset) {

        log.info("[START] ToyCreatedEvent started to be consumed. Topic: {}, Event: {}, Partition: {}, Offset: {}", topicName, event, partition, offset);

        Gson gson = new Gson();
        ToyCreatedEvent toyCreatedEvent = gson.fromJson(event, ToyCreatedEvent.class);

        Toy toy = toyCreatedEvent.toToy();

        service.processEvent(toy);
    }
}
