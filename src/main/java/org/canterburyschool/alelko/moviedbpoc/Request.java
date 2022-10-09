package org.canterburyschool.alelko.moviedbpoc;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Request {
	private static final Logger LOG = LogManager.getLogger(Request.class);
	
	private Map<String, String> parms;
	
	public Request() {
		super();
		
		parms = new HashMap<String, String>();
	}
	
	public String getParameter(String key) {
		return parms.get(key);
	}
	
	public void setParameter(String key, String value) {
		parms.put(key, value);
	}
	
	public void removeParameter(String key) {
		parms.remove(key);
	}
	
	
}
