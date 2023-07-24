package edu.miu.datainputservice.controller;

import edu.miu.datainputservice.domain.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
public class PushDataController {

    private final KafkaTemplate<String, Long> kafkaTemplate;

    @Value("${cds.topic.output}")
    private String output;

    public PushDataController(KafkaTemplate<String, Long> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String pushData(@RequestBody DataSource source) {
        try {
            kafkaTemplate.send(output, source.getData());
        } catch (Exception ex) {
            log.info("Error: ", ex);
        }
        return "success";
    }
}
