package com.course.producer;

import com.course.entity.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class InvoiceProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private ObjectMapper objectMapper22 = new ObjectMapper();


    public void send22(Invoice invoice) throws JsonProcessingException {
        var json = objectMapper22.writeValueAsString(invoice);
        kafkaTemplate.send("t_invoice", invoice.getNumber(), json);
    }



}
