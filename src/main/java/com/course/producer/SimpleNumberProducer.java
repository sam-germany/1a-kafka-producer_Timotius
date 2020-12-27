package com.course.producer;

import com.course.entity.SimpleNumber;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class SimpleNumberProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private ObjectMapper objectMapper22 = new ObjectMapper();

    public void send22(SimpleNumber simpleNumber) throws JsonProcessingException {
        var json = objectMapper22.writeValueAsString(simpleNumber);
        kafkaTemplate.send("t_simple_number",json);
    }



}
