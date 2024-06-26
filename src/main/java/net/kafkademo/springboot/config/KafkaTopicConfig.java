package net.kafkademo.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafkaDemoTopic(){
        return TopicBuilder.name("demokafka")
                .build();
    }
}

/*
Flow of kafka:
+ Kafka config: Add topic name
+ Kafka controller:
 */