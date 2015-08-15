package com.emobile.smis.webservice.logic;

import org.codehaus.jackson.map.ObjectMapper;

public interface SmisBaseQueryLogic {
	
	
	public String process(String data, ObjectMapper objMapper, String pathInfo);
}
