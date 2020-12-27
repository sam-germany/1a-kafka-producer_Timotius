package com.course;

import com.course.entity.FoodOrder;
import com.course.producer.FoodOrderProducer;
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


	@Override
	public void run(String... args) throws Exception {

		var chickenOrder = new FoodOrder(2, "Chicken");
		var fishOrder = new FoodOrder(10, "Fish");
		var pizzaOrder = new FoodOrder(5, "pizza");

		foodOrderProducer22.send(chickenOrder);
		foodOrderProducer22.send(fishOrder);
		foodOrderProducer22.send(pizzaOrder);


	}
}
