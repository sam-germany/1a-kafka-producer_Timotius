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

    @Autowired                  // KafkaProperties is a predefined class, we can define any configuration for kafka
    private KafkaProperties kafkaProperties22;// it is same as we can define any property in the application.yml
 // file or we can define here in the @Configuration class, if we have defined any property in the .yml file
 // and here we can also override that property by re-defining it.

// video 44-45
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
/*
Note: Spring has created many predefined configuration object for us, but we can also override those predefined
configure object with our own configuration,for this we need to do these steps

Step 1) first create that object as we are creating  "ProducerFactory<String,String>"

Step 2) for configuring it we need to pass properties, to pass these properties we need "KafkaProperties"
        as we are passing above  "properties22.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, "180000");"

Step3) at the end we need to create a "new KafkaTemplate<>"  object  with @Bean, so at run time these
       new configuration will be taken by the Spring framework




 */
