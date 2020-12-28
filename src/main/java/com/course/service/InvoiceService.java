package com.course.service;

import com.course.entity.Invoice;

import java.util.concurrent.ThreadLocalRandom;

//@Service
public class InvoiceService {

    private static int counter = 0;



    public Invoice generateInvoice() {
      counter++;
      var invoiceNumber = "INV-" + counter;
      var invoiceAmount = ThreadLocalRandom.current().nextInt(1,1000);

      return new Invoice(invoiceNumber,invoiceAmount,"USD");
    }
}
