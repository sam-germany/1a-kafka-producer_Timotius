package com.course.producer;

import com.course.entity.Image;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class ImageProducer {

   @Autowired
   private KafkaTemplate<String,String> kafkaTemplate22;

   private ObjectMapper objectMapper = new ObjectMapper();

   public void send22(Image image) throws JsonProcessingException {

      var json = objectMapper.writeValueAsString(image);
      kafkaTemplate22.send("t_image", image.getType(), json);
   }
}
