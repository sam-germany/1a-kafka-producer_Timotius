package com.course;

import com.course.entity.FoodOrder;
import com.course.entity.SimpleNumber;
import com.course.producer.FoodOrderProducer;
import com.course.producer.SimpleNumberProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableScheduling
@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}


	@Autowired
	private FoodOrderProducer foodOrderProducer22;
    @Autowired
	private SimpleNumberProducer simpleNumberProducer22;


	@Override
	public void run(String... args) throws Exception {

		var chickenOrder = new FoodOrder(2, "Chicken");
		var fishOrder = new FoodOrder(10, "Fish");
		var pizzaOrder = new FoodOrder(5, "pizza");

		foodOrderProducer22.send22(chickenOrder);
		foodOrderProducer22.send22(fishOrder);
		foodOrderProducer22.send22(pizzaOrder);

		for( int i =0; i< 103; i++) {
			var simpleNumber  = new SimpleNumber(i);
			simpleNumberProducer22.send22(simpleNumber);
		}

	}
}
