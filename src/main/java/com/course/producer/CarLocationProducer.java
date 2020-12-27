package com.course.producer;

import com.course.entity.CarLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarLocationProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate22;

    private ObjectMapper objectMapper22 = new ObjectMapper();

    public void send22(CarLocation carLocation) throws JsonProcessingException {

       var json = objectMapper22.writeValueAsString(carLocation);
       kafkaTemplate22.send("t_location", carLocation.getCarId(),json );
    }


}
