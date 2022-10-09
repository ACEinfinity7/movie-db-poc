package org.canterburyschool.alelko.moviedbpoc;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Session {

	private static final Logger LOG = LogManager.getLogger(Session.class);

	public static final String ID = "id";

	private static Session instance;
	private Map<String, Object> holdingPlace;

	private Session() {
		this.holdingPlace = new HashMap<String, Object>();
	}

	public static Session getInstance() {

		if (instance == null) {
			instance = new Session();
		}

		return instance;
	}

	public void give(String key, Object value) {
		holdingPlace.put(key, value);
	}

	public Object take(String key) {
		return holdingPlace.get(key);
	}
	
	public void remove(String key) {
		holdingPlace.remove(key);
	}
}
