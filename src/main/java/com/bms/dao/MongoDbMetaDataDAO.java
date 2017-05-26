/*package com.bms.dao;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.bson.Document;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

*//**
 * @author 540491
 *
 *//*
@Component
public class MongoDbMetaDataDAO {

	@Autowired
	private MongoDbFactory mongoDb;

	@PostConstruct
	public void initializeDB() throws JsonParseException, JsonMappingException, IOException, ParseException {
		if (!isRecordExists()) {
			insertCollections();
		}
		;
	}

	*//**
	 * method to insert the collections data in mongoDB
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 *//*
	public void insertCollections() throws JsonParseException, JsonMappingException, IOException {

		MongoCollection<Document> collection = ((MongoDatabase) mongoDb).getCollection("ProductList");
		List<Document> documents = getData("ProductList");
		collection.insertMany(documents);

	}

	public List<Document> getData(String collectionName) throws JsonParseException, JsonMappingException, IOException {
		StringBuffer path = new StringBuffer();
		path.append("metaData").append("ProductList").append(".json");
		String content = FileUtils.readFileToString(new File(this.getClass().getResource(path.toString()).getFile()));

		Map<String, Object> result = new ObjectMapper().readValue(content, HashMap.class);

		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get(collectionName);

		List<Document> documentList = new ArrayList<Document>();

		for (Map<String, Object> obj : list) {
			documentList.add(new Document(obj));
		}

		return documentList;
	}

	*//**
	 * method to check whether the record exists in mongoDB
	 *//*
	public boolean isRecordExists() {
		MongoCollection<Document> collection = ((MongoDatabase) mongoDb).getCollection("ProductList");
		if (collection.count() > 0) {
			return true;
		} else {
			return false;
		}
	}

}*/