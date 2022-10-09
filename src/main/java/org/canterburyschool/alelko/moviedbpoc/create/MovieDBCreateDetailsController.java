package org.canterburyschool.alelko.moviedbpoc.create;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;
import org.canterburyschool.alelko.moviedbpoc.service.MovieDBService;
import org.canterburyschool.alelko.moviedbpoc.service.MovieDBServiceFactory;

public class MovieDBCreateDetailsController implements Controller {
	private static final Logger LOG = LogManager.getLogger(MovieDBCreateDetailsController.class);

	public static final String ROUTING_NAME = "dbCreateDetails";

	private MovieDBService svc;
	private MovieDBCreateDetailsView view;
	private Request req;

	public MovieDBCreateDetailsController() {
		super();

		svc = MovieDBServiceFactory.getService();
		view = new MovieDBCreateDetailsView();
	}

	public Response doDisplay() {
		int id = Integer.valueOf(req.getParameter("id"));
		String title = req.getParameter("title");
		String imdbId = req.getParameter("imdbId");

		svc.createMovie(id, title, imdbId);

		return new Response(MenuCreateDetailsController.ROUTING_NAME, req);

	}
	
	public Request getRequest() {
		return req;
	}
	
	public void setRequest(Request req) {
		this.req = req;
	}

}
