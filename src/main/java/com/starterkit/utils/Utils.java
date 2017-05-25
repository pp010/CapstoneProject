package com.starterkit.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

/**
 * Class to find out the vcap_service
 * and vcap_app.
 * @author 540491
 *
 */
@Component
public class Utils {

	/**
	 * It will return vcap_service 
	 * name of rabbit mq service attached to application.
	 * @param vcap_service
	 * @return
	 */
	public String getVcapServiceName(String vcap_service) {
		JSONParser jsonParser = new JSONParser();
		JSONObject bluePrintObject;
		String serviceName = null;
		try {
			bluePrintObject = (JSONObject) jsonParser.parse(vcap_service);
			for (Object key : bluePrintObject.keySet()) {
				if (key.toString().toLowerCase().contains("mq")) {
					JSONArray obj = (JSONArray) bluePrintObject.get(key.toString());
					JSONObject object = (JSONObject) obj.get(0);
					serviceName = (String) object.get("name");
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return serviceName;

	}

	/**
	 * It will return name of the application.
	 * @param vcap_app
	 * @return
	 */
	public String getVcapAppName(String vcap_app) {
		String appName = null;
		JSONParser jsonParser = new JSONParser();
		JSONObject bluePrintObject;
		try {
			bluePrintObject = (JSONObject) jsonParser.parse(vcap_app);
			appName = (String) bluePrintObject.get("application_name");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return appName;
	}

}
