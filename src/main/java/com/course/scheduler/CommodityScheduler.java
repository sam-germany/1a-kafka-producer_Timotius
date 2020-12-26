package com.course.scheduler;

import com.course.entity.Commodity;
import com.course.producer.CommodityProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@Service
public class CommodityScheduler {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CommodityProducer producer;

    @Scheduled(fixedRate = 5000)
    public void fetchCommodities() {
        var  commodities22 = restTemplate.exchange("http://localhost:8080/api/commodity/v1/all",
                                                                       HttpMethod.GET,
                                                                      null,
                                                                     new ParameterizedTypeReference<List<Commodity>>() {
                                                        }).getBody();

        commodities22.forEach(x -> {
                                        try {
                                             producer.sendMessage(x);
                                        } catch (JsonProcessingException e) {
                                             e.printStackTrace();
                                        }
                              });
    }
}
/*
new ParameterizedTypeReference<List<Commodity>>()

here we are getting as response in   restTemplate.exchange()     a json object , but as we need a List<Commondity>
so for getting the list he uses   new ParameterizedTypeReference<List<Commodity>>()


 */
