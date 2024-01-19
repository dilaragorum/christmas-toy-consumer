package com.example.christmastoys.consumer;

import com.example.christmastoys.event.ToyCreatedEvent;
import com.example.christmastoys.annotation.ValidateToyCreatedEvent;
import com.example.christmastoys.model.Toy;
import com.example.christmastoys.service.ChristmasToyCheckService;
import com.google.gson.Gson;
import jakarta.validation.Valid;
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

    private final ChristmasToyCheckService service;

    private final Gson gson = new Gson();

    @ValidateToyCreatedEvent
    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void ConsumeToyRequestCreate(@Payload @Valid String event, // TODO: bunu ToyCreatedEvent yapamıyorum, conversion hatası veriyor.
                                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                        @Header(KafkaHeaders.OFFSET) int offset) {
        log.info("[START] ToyCreatedEvent started to be consumed. Topic: {}, Event: {}, Partition: {}, Offset: {}", topicName, event, partition, offset);

        ToyCreatedEvent toyCreatedEvent = gson.fromJson(event, ToyCreatedEvent.class);

        Toy toy = toyCreatedEvent.toToy();

        service.processEvent(toy);
    }
}
