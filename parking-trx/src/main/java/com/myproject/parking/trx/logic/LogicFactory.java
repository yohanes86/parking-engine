package com.emobile.smis.webservice.logic;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmisLogicFactory {
	private static final Logger LOG = LoggerFactory.getLogger(SmisLogicFactory.class);
	
	private Map<String, SmisBaseQueryLogic> logic;

	
	public Map<String, SmisBaseQueryLogic> getLogic() {
		return logic;
	}

	public void setLogic(Map<String, SmisBaseQueryLogic> logic) {
		this.logic = logic;
		LOG.info("logic :"+ logic);
	}
}
