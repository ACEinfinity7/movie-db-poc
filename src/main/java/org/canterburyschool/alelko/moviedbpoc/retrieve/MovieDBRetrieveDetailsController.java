package org.canterburyschool.alelko.moviedbpoc.retrieve;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.Request;
import org.canterburyschool.alelko.moviedbpoc.Response;
import org.canterburyschool.alelko.moviedbpoc.Session;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;
import org.canterburyschool.alelko.moviedbpoc.dto.MovieDTO;
import org.canterburyschool.alelko.moviedbpoc.service.MovieDBService;
import org.canterburyschool.alelko.moviedbpoc.service.MovieDBServiceFactory;

public class MovieDBRetrieveDetailsController implements Controller {

	private static final Logger LOG = LogManager.getLogger(MovieDBRetrieveDetailsController.class);

	public static final String ROUTING_NAME = "dbShowDetails";

	private MovieDBService svc;
	private MovieDBRetrieveDetailsView view;
	private Request req;

	public MovieDBRetrieveDetailsController() {
		super();

		svc = MovieDBServiceFactory.getService();
		view = new MovieDBRetrieveDetailsView();
	}

	public Response doDisplay() {

//		get movie from service
		int id = Integer.valueOf(req.getParameter("id"));

		MovieDTO dto = this.svc.retrieveMovie(id);

//		use dto to populate view fields
		this.view.setId(dto.getId());
		this.view.setTitle(dto.getTitle());
		this.view.setImdbId(dto.getImdbId());

//		route to view
		this.view.display();

		return new Response(MenuRetrieveDetailsController.ROUTING_NAME, req);
	}

	public Request getRequest() {
		return req;
	}

	public void setRequest(Request req) {
		this.req = req;
		
	}

}
