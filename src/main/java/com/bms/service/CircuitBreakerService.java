package com.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CircuitBreakerService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getBackupGuide", commandKey = "hystrixKey")
	public String getGuide() {
		return "<inside getGuid>";
	}

	public String getBackupGuide() {
		return "<inside getbackupGuide>";
	}
	
}
