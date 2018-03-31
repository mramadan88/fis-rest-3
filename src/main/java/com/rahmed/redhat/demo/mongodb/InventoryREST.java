package com.rahmed.redhat.demo.mongodb;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class InventoryREST extends RouteBuilder{
	
	//we can use mongo component but i want to showcase spring data
	//private String inventoryCreate = "mongodb:connectionBean?database=databaseName&collection=collectionName&operation=operationName[&moreOptions...]"; 

	
    @Override
    public void configure() {       
    	onException(Exception.class)
	    	.handled(true)
	    	.setBody(simple("Invetory cannot be Updated"));
    	
    	
    	
		rest("/inventory").description("Invetory service")
		
			.post("/").type(Inventory.class).description("Create a new Inventory")
			.route().routeId("insert-inventory").tracing()
			.log("Order Id is ${body.id}")
			.setHeader("id",simple("${body.id}"))
			.log("Inventory Id is ${header.id} whole body is ${body}")
			.log("Creating new inventory document")
			.bean(InventoryService.class,"createInventory")
			.transform(constant("Invetory Created"))
			.endRest();
			
			

    			
	}
}
