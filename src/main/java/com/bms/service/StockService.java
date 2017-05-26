package com.bms.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.domain.ProductList;
import com.bms.repostiries.JpaProductList;

@Service
@SuppressWarnings("unchecked")
public class StockService {

	@Autowired
	private JpaProductList jpaProductList;

	public JSONObject getList() {
		return (JSONObject) jpaProductList.findAll();
	}

	public JSONObject insertList(String input) {

		try {
			Object obj = new JSONParser().parse(input);
			JSONObject json = (JSONObject) obj;
			
			System.out.println("INSERT PROCESS");
			
			jpaProductList.insert(new ProductList((String) json.get("productId"), (String) json.get("productName"),
					(String) json.get("Quantity")));
			return (JSONObject) jpaProductList.findAll();
		} catch (Exception e) {
			return (JSONObject) new JSONObject().put("Error", "Insert Failed");
		}
	}

	public JSONObject updateList(String id, String input) {

		try {
			ProductList productList = jpaProductList.findOne(id);
			
			System.out.println(productList);
			
			Object obj = new JSONParser().parse(input);
			JSONObject json = (JSONObject) obj;
			productList.setQuantity((String) json.get("Quantity"));
			
			System.out.println(productList);
			
			jpaProductList.save(productList);
			productList = jpaProductList.findOne(id);
			
			System.out.println(productList);
			
			json.put("id", productList.getId());
			json.put("productId", productList.getProductId());
			json.put("productName", productList.getProductName());
			json.put("Quantity", productList.getQuantity());
			return json;
		} catch (Exception e) {
			return (JSONObject) new JSONObject().put("Error", "Update Failed");
		}
	}

	public JSONObject deleteList(String id) {
		jpaProductList.delete(id);
		return (JSONObject) new JSONObject().put(id.toString(), "Delete Success");
	}

}
