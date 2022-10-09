package org.canterburyschool.alelko.moviedbpoc.farewell;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.App;
import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;

public class FarewellController implements Controller {

	private static final Logger LOG = LogManager.getLogger(FarewellController.class);

	public static final String ROUTING_NAME = "farewell";

	private FarewellView view;
	private Request req;

	public FarewellController() {
		super();
		view = new FarewellView();
	}

	public Response doDisplay() {
		view.display();

		return new Response(App.END, req);
	}

	public Request getRequest() {
		return req;
	}

	public void setRequest(Request req) {
		this.req = req;

	}
}
