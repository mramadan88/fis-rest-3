package com.rahmed.redhat.demo.mongodb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories
class MongoDBSetup extends AbstractMongoConfiguration {

	@Value("${service.mongodb.name}")
	private String mongoServiceName;

	@Value("${service.mongodb.username}")
	private String mongoServiceUsername;

	@Value("${service.mongodb.password}")
	private String mongoServicePassword;

	@Value("${service.mongodb.database}")
	private String mongoDatabaseName;

	@Override
	protected String getDatabaseName() {
		return mongoDatabaseName;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(new ServerAddress(mongoServiceName), Arrays.asList(MongoCredential
				.createCredential(mongoServiceUsername, mongoDatabaseName, mongoServicePassword.toCharArray())));
	}
}