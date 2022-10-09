package org.canterburyschool.alelko.moviedbpoc.mainMenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;
import org.canterburyschool.alelko.moviedbpoc.Session;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;
import org.canterburyschool.alelko.moviedbpoc.create.MenuCreateDetailsController;
import org.canterburyschool.alelko.moviedbpoc.delete.MenuDeleteDetailsController;
import org.canterburyschool.alelko.moviedbpoc.farewell.FarewellController;
import org.canterburyschool.alelko.moviedbpoc.retrieve.MenuRetrieveDetailsController;
import org.canterburyschool.alelko.moviedbpoc.update.MenuUpdateDetailsController;

public class MainMenuController implements Controller {

	private static final Logger LOG = LogManager.getLogger(MainMenuController.class);

	public static final String ROUTING_NAME = "mainMenu";

	private MainMenuView view;
	private Request req;

	public MainMenuController() {
		super();
		view = new MainMenuView();
		req = new Request();
	}

	public Response doDisplay() {

		String nextController = MainMenuController.ROUTING_NAME;
		
		view.display();
		
		int action = view.getAction();

		switch (action) {
		case 1:
			nextController = MenuCreateDetailsController.ROUTING_NAME;
			break;
		case 2:
			nextController = MenuRetrieveDetailsController.ROUTING_NAME;
			break;
		case 3:
			nextController = MenuUpdateDetailsController.ROUTING_NAME;
			break;
		case 4:
			nextController = MenuDeleteDetailsController.ROUTING_NAME;
			break;
		case -1:
			nextController = FarewellController.ROUTING_NAME;
			break;
		default:
			System.out.println("Action id not supported");
		}

		Response resp = new Response(nextController, req);
		return resp;
	}

	public Request getRequest() {
		return req;
	}

	public void setRequest(Request req) {
		this.req = req;
		
	}

}
