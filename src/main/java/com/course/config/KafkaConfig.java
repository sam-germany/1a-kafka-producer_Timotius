package com.course.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Autowired                             // KafkaProperties is a predefined class, we can define any configuration
    private KafkaProperties kafkaProperties22;   // for kafka and it also override the already defined configuration
                                                //that we defined in the application.yml  file

    @Bean
    public ProducerFactory<String,String> producerFactory22() {
        var properties22 = kafkaProperties22.buildProducerProperties();
        properties22.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, "180000");   // to set the time for auto-refreshing
                  // by the Kafka internally, like it will go  for the producer and check for the  configurations if
                                                                          // any this is updated in the configuration

         return new DefaultKafkaProducerFactory<String,String>(properties22);
    }

    @Bean                               // for overriding Producer configuration we need to write KafkaTemplate
    public KafkaTemplate<String,String> kafkaTemplate() {
         return new KafkaTemplate<String,String>(producerFactory22());
    }



}
