package org.canterburyschool.alelko.moviedbpoc.controller;

import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;

public interface Controller {

	public Response doDisplay();
	
	public Request getRequest();
	
	public void setRequest(Request req);
}
