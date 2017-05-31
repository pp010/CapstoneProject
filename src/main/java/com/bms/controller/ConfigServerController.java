package com.bms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/config")
public class ConfigServerController {
	
	@Value("${db_check}")
	String value;
	
	@RequestMapping("/getData")
	public String getData() {
		return String.format("configServer Value is: %s", value);
	}

}
