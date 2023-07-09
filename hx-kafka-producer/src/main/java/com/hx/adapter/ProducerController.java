package com.hx.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 消费者控制器
 *
 * @author kyle
 * @date 2023/07/09
 */
@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("produce")
    public void produceData() {
        System.out.println("1");
    }

    @Value("${kafka.topic.name}")
    private String topicName;

    @PostMapping("/sendMsg")
    public String sendMsg(@RequestBody(required = false) String jsonString) {
        jsonString = jsonString==null? LocalDateTime.now().toString(): jsonString;
        kafkaTemplate.send(topicName, jsonString);
        return "Kafka Message Send OK!";
    }

}
