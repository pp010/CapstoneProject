package com.bms.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bms.domain.ProductList;
import com.bms.repostiries.JpaProductList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author 540491
 *
 */
@Component
public class MongoDbMetaDataDAO {

	@Autowired
	private JpaProductList jpaProductList;

	@PostConstruct
	public void initializeDB() throws JsonParseException, JsonMappingException, IOException, ParseException {
		if (!isRecordExists()) {
			System.out.println(
					"======================================================================================================================initializeDB");
			insertCollections();
		}
		;
	}

	/**
	 * method to insert the collections data in mongoDB
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ParseException
	 */
	public void insertCollections() throws JsonParseException, JsonMappingException, IOException, ParseException {

		System.out.println(
				"======================================================================================================================insertCollections");
		List<ProductList> documents = getData("ProductList");
		for (ProductList pl : documents) {
			System.out.println(
					"===================================================================================" + pl);
			jpaProductList.insert(pl);
		}
	}

	public List<ProductList> getData(String collectionName)
			throws JsonParseException, JsonMappingException, IOException, ParseException {
		StringBuffer path = new StringBuffer();
		path.append("/metaData/").append("ProductList").append(".json");
		String content = FileUtils.readFileToString(new File(this.getClass().getResource(path.toString()).getFile()));
		System.out.println("==============================================================" + content);

		/*
		 * Map<String, Object> result = new ObjectMapper().readValue(content,
		 * HashMap.class); System.out.println(
		 * "=============================================================="
		 * +result); List<Map<String, Object>> list = (List<Map<String,
		 * Object>>) result.get(collectionName);
		 * 
		 * List<ProductList> documentList = new ArrayList<ProductList>();
		 * 
		 * for (Map<String, Object> obj : list) { documentList.add((ProductList)
		 * obj); }
		 */

		List<ProductList> list = new ArrayList<>();
		JSONObject jsnobject = (JSONObject) new JSONParser().parse(content);
		System.out.println("==============================================================" + jsnobject.toString());
		JSONArray jsonArray = (JSONArray) jsnobject.get("ProductList");
		System.out.println("==============================================================" + jsonArray.toString());
		for (Object obj : jsonArray) {
			JSONObject json = (JSONObject) obj;
			System.out.println("==============================================================" + json);
			list.add(new ProductList((String) json.get("productId"), (String) json.get("productName"),
					(String) json.get("Quantity")));
		}
		System.out.println("==============================================================" + list);
		return list;

	}

	/**
	 * method to check whether the record exists in mongoDB
	 */
	public boolean isRecordExists() {

		System.out.println(
				"======================================================================================================================isRecordExists");

		if (jpaProductList.count() > 0) {

			System.out.println(
					"======================================================================================================================true");

			return true;
		} else {
			return false;
		}
	}

}