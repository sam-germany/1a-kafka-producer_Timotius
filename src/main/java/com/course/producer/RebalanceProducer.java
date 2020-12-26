package com.course.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class RebalanceProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private int i = 0;

//    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        i++;
        kafkaTemplate.send("t_rebalance", "Counter is "+ i);

    }

}
