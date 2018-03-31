package com.rahmed.redhat.demo.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomSequencesRepository extends MongoRepository<CustomSequences, String> {
}
