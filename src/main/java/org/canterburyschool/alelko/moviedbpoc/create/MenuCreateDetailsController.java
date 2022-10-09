package org.canterburyschool.alelko.moviedbpoc.create;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;
import org.canterburyschool.alelko.moviedbpoc.mainMenu.MainMenuController;

public class MenuCreateDetailsController implements Controller {
	private static final Logger LOG = LogManager.getLogger(MenuCreateDetailsController.class);

	public static final String ROUTING_NAME = "menuCreateDetails";

	private MenuCreateDetailsView view;
	private Request req;

	public MenuCreateDetailsController() {
		super();

		view = new MenuCreateDetailsView();
	}

	public Response doDisplay() {
		String nextController = MovieDBCreateDetailsController.ROUTING_NAME;

		view.display();

		int id = view.getId();
		String title = view.getTitle();
		String imdbId = view.getImdbId();

		if (id == -1) {
			nextController = MainMenuController.ROUTING_NAME;
		} else {
			req.setParameter("id", String.valueOf(id));
			req.setParameter("title", title);
			req.setParameter("imdbId", imdbId);
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
