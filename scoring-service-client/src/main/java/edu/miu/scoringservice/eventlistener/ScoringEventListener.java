package edu.miu.scoringservice.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScoringEventListener {

    @KafkaListener(topics = "scoringTopicOne", groupId = "scoringTopicOne")
    public void onScoringEventListener(@Payload Integer message, @Headers MessageHeaders headers) {
        log.info("=========> Scoring: {}", message);
    }
}
