package com.rahmed.redhat.demo.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    public Inventory findByInventoryId(String inventoryId);

}