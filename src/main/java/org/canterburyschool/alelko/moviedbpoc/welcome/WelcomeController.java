package org.canterburyschool.alelko.moviedbpoc.welcome;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;
import org.canterburyschool.alelko.moviedbpoc.mainMenu.MainMenuController;

public class WelcomeController implements Controller{
	
	private static final Logger LOG = LogManager.getLogger(WelcomeController.class);
	
	public static final String ROUTING_NAME = "welcome";
	
	private WelcomeView view;
	private Request req;
	
	public WelcomeController() {
		super();
		view = new WelcomeView();
	}
	
	public Response doDisplay() {
		view.display();
		
		return new Response(MainMenuController.ROUTING_NAME, req);
		
	}


	public Request getRequest() {
		return req;
	}

	public void setRequest(Request req) {
		this.req = req;
		
	}
}
