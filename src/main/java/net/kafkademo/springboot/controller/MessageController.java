package net.kafkademo.springboot.controller;

import net.kafkademo.springboot.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);
    // step 1: DI
//    private KafkaProducer kafkaProducer;
//
//    public MessageController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

    // step 2: DI
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        try {
            kafkaProducer.sendMessage(message);

        } catch (Exception e) {
            log.info("Error publishing message", e);
        }
        return ResponseEntity.ok(message);
    }
}