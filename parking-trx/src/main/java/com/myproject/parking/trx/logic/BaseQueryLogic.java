package com.myproject.parking.trx.logic;

import org.codehaus.jackson.map.ObjectMapper;

public interface BaseQueryLogic {
	
	public String process(String data, ObjectMapper objMapper, String pathInfo);
}
