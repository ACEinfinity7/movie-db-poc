package org.canterburyschool.alelko.moviedbpoc.retrieve;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;
import org.canterburyschool.alelko.moviedbpoc.Session;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;
import org.canterburyschool.alelko.moviedbpoc.mainMenu.MainMenuController;

public class MenuRetrieveDetailsController implements Controller {

	private static final Logger LOG = LogManager.getLogger(MenuRetrieveDetailsController.class);

	public static final String ROUTING_NAME = "menuRetrieveDetails";

	private MenuRetrieveDetailsView view;
	private Request req;

	public MenuRetrieveDetailsController() {
		super();

		view = new MenuRetrieveDetailsView();

	}

	public Response doDisplay() {
		String nextController = MovieDBRetrieveDetailsController.ROUTING_NAME;

		view.display();

		int id = view.getId();

		if (id == -1) {

			nextController = MainMenuController.ROUTING_NAME;
		} else {

			req.setParameter("id", String.valueOf(id));
		}

		return new Response(nextController, req);
	}

	public Request getRequest() {
		return req;
	}

	public void setRequest(Request req) {
		this.req = req;
		
	}
}
