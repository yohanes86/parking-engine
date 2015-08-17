package com.myproject.parking.trx.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

public interface BaseQueryLogic {
	
//	public String process(String data, ObjectMapper objMapper, String pathInfo);
	
	public String process(HttpServletRequest request, HttpServletResponse response,String data, ObjectMapper objMapper, String pathInfo);
}
