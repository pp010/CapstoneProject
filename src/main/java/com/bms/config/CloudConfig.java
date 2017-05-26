package com.bms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;

import com.bms.utils.Utils;

import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Configuration

public class CloudConfig extends AbstractCloudConfig {
	private MongoClient mongoClient;
	@Autowired
	private Utils utils;

	@Bean
	public MongoDbFactory documentMongoDbFactory() {
		return connectionFactory().mongoDbFactory();
	}

	@Bean
	public MongoDatabase mongoDatabase() {

		String uri = null;
		JsonObject cloudConfig = utils
				.getCredentials(System.getenv(utils.getMongoVcapServiceName(System.getenv("VCAP_SERVICES"))));
		uri = cloudConfig.get("uri").getAsString();
		mongoClient = new MongoClient(new MongoClientURI(uri));
		String databaseName = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		return mongoClient.getDatabase(databaseName);
	}
}
