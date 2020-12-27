package com.course.scheduler;

import com.course.entity.CarLocation;
import com.course.producer.CarLocationProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
public class CarLocationScheduler {
    private static final Logger log = LoggerFactory.getLogger(CarLocationScheduler.class);

    private CarLocation carOne;
    private CarLocation carTwo;
    private CarLocation carThree;

    @Autowired
    private CarLocationProducer producer22;

    public CarLocationScheduler() {
        var now = System.currentTimeMillis();

        carOne = new CarLocation("car-one", now, 0);
        carTwo = new CarLocation("car-two", now,110);
        carThree = new CarLocation("car-three",now,95);
    }

    @Scheduled(fixedRate = 10000)
    public void generateCarLocation() {
        var now = System.currentTimeMillis();

        carOne.setTimestamp(now);
        carTwo.setTimestamp(now);
        carThree.setTimestamp(now);

        carOne.setDistance(carOne.getDistance() + 1);
        carTwo.setDistance(carTwo.getDistance() - 1);
        carThree.setDistance(carThree.getDistance() + 1);

     try {
         producer22.send22(carOne);
         log.info("sent  {}", carOne);

         producer22.send22(carTwo);
         log.info("sent  {}", carTwo);

         producer22.send22(carThree);
         log.info("sent  {}", carThree);
     }catch (Exception e) {
         log.warn("Error happend  {} ", e);
     }
    }

}
