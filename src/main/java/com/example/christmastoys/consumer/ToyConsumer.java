package com.example.christmastoys.consumer;

import com.example.christmastoys.event.ToyCreatedEvent;
import com.example.christmastoys.service.ChristmasToyRegionSelectionService;
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
//TODO: topic ismini tekrar kontrol et.
public class ToyConsumer {

    private final ChristmasToyRegionSelectionService service;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.consumer.group-id}")
    public void ConsumeToyRequestCreate(@Payload String event,
                                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                        @Header(KafkaHeaders.OFFSET) int offset) {
        // TODO: aldığım event json string'ini, deserialize/unmarshal edip ToyCreatedEvent'a çevirmeliyim. (new StringJsonMessageConverter(mapper) -  private final ObjectMapper mapper;
        // http://localhost:8080/topics/saint-nicholas-fairy-christmas-toys-created?o=-1&p=-1&q&s=50#messages

        log.info("[START] ToyCreatedEvent started to be consumed. Topic: {}, Event: {}, Partition: {}, Offset: {}", topicName, event, partition, offset);

        Gson gson = new Gson();
        ToyCreatedEvent toyCreatedEvent = gson.fromJson(event, ToyCreatedEvent.class);



        service.processEvent(toyCreatedEvent);
    }
}
