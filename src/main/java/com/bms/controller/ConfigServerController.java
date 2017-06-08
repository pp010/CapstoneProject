package com.bms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/configserver")
public class ConfigServerController {

	@Value("${db_check}")
	String db_check;
	
	@Value("${secret_api_key}")
	String secret_api_key;

	@RequestMapping(value = "/dbcheck", method = RequestMethod.GET)
	public String getDataDbCheck() {
		return String.format("configServer Value for db_check is: %s", db_check);
	}

	@RequestMapping(value = "/apicheck", method = RequestMethod.GET)
	public String getDataApiKey() {
		return String.format("configServer Value for secret_api_key is: %s", secret_api_key);
	}
}
