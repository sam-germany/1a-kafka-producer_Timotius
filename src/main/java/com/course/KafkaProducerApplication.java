package com.course;

import com.course.producer.InvoiceProducer;
import com.course.service.InvoiceService;
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
	 private InvoiceService invoiceService22;
	 @Autowired
	 private InvoiceProducer invoiceProducer22;


	@Override
	public void run(String... args) throws Exception {
       for(int i=0;i<10; i++){
       	var invoice  = invoiceService22.generateInvoice();

       	if(i >=5){ invoice .setAmount(-1);  }

       	invoiceProducer22.send22(invoice);
		}

	}
}
