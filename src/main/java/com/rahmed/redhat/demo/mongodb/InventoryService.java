package com.rahmed.redhat.demo.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {

	@Autowired
	private InventoryRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

	@Autowired
	private CustomSequenceService customSeqService;

	static final String inventorySeqName = "inventory_seq";

	public void createInventory(Inventory inventory) {

		logger.info("Reached createInventory");

		long inventroyID = customSeqService.getNext(inventorySeqName);
		
		logger.info("inventroyID==" + inventroyID);

		inventory.setId(inventroyID+"");
		repository.save(inventory);
	}

}