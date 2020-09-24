package com.learncamel.recipientlist;

import org.apache.camel.Exchange;

public class RecipientEIPProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {

        String employeeType =
                exchange.getIn().getHeader("type", String.class);
        System.out.println("~~~~~~~~~~ EXCHANGE HEADER BELOW ~~~~~~~~~");
        System.out.println(exchange.getIn().getBody(String.class));
        System.out.println(exchange.getIn().getHeaders());
        System.out.println(exchange);
        if (employeeType.equals("senior")) {
            exchange.getIn().setHeader("type", "file:xmlsenior");
            System.out.println(exchange.getIn().getHeaders());
        } else {
            exchange.getIn().setHeader("type", "file:xmljunior");
        }

    }
}
