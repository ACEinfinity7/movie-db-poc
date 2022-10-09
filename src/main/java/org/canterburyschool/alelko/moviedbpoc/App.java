package org.canterburyschool.alelko.moviedbpoc;

import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.controller.Controller;
import org.canterburyschool.alelko.moviedbpoc.create.MenuCreateDetailsController;
import org.canterburyschool.alelko.moviedbpoc.create.MovieDBCreateDetailsController;
import org.canterburyschool.alelko.moviedbpoc.delete.MenuDeleteDetailsController;
import org.canterburyschool.alelko.moviedbpoc.delete.MovieDBDeleteDetailsController;
import org.canterburyschool.alelko.moviedbpoc.dto.MovieDTO;
import org.canterburyschool.alelko.moviedbpoc.farewell.FarewellController;
import org.canterburyschool.alelko.moviedbpoc.mainMenu.MainMenuController;
import org.canterburyschool.alelko.moviedbpoc.retrieve.MenuRetrieveDetailsController;
import org.canterburyschool.alelko.moviedbpoc.retrieve.MovieDBRetrieveDetailsController;
import org.canterburyschool.alelko.moviedbpoc.service.MovieDBListService;
import org.canterburyschool.alelko.moviedbpoc.service.MovieDBServiceFactory;
import org.canterburyschool.alelko.moviedbpoc.service.ServiceType;
import org.canterburyschool.alelko.moviedbpoc.update.MenuUpdateDetailsController;
import org.canterburyschool.alelko.moviedbpoc.update.MovieDBUpdateDetailsController;
import org.canterburyschool.alelko.moviedbpoc.welcome.WelcomeController;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

public class App {

	private static final Logger LOG = LogManager.getLogger(App.class);

	public static final String START = WelcomeController.ROUTING_NAME;
	public static final String END = "end";

	public static String nextController;

	public static void main(String[] args) throws Exception {

		MovieDBListService.addMovie(new MovieDTO(1, "Hot Fuzz", "tt0001"));
		MovieDBListService.addMovie(new MovieDTO(2, "Baby Driver", "tt0002"));
		MovieDBListService.addMovie(new MovieDTO(3, "Shaun of the Dead", "tt0003"));
		MovieDBListService.updateMovie(new MovieDTO(3, "Shaun of the Dead", "tt0004"));

		MovieDBServiceFactory.SERVICE_TYPE = ServiceType.SQLITE;

		Routing router = Routing.getInstance();

		router.addRoute(WelcomeController.ROUTING_NAME, WelcomeController.class);
		router.addRoute(FarewellController.ROUTING_NAME, FarewellController.class);
		
		router.addRoute(MainMenuController.ROUTING_NAME, MainMenuController.class);
		
		router.addRoute(MenuCreateDetailsController.ROUTING_NAME, MenuCreateDetailsController.class);
		router.addRoute(MovieDBCreateDetailsController.ROUTING_NAME, MovieDBCreateDetailsController.class);

		router.addRoute(MenuRetrieveDetailsController.ROUTING_NAME, MenuRetrieveDetailsController.class);
		router.addRoute(MovieDBRetrieveDetailsController.ROUTING_NAME, MovieDBRetrieveDetailsController.class);
		
		router.addRoute(MenuUpdateDetailsController.ROUTING_NAME, MenuUpdateDetailsController.class);
		router.addRoute(MovieDBUpdateDetailsController.ROUTING_NAME, MovieDBUpdateDetailsController.class);
		
		router.addRoute(MenuDeleteDetailsController.ROUTING_NAME, MenuDeleteDetailsController.class);
		router.addRoute(MovieDBDeleteDetailsController.ROUTING_NAME, MovieDBDeleteDetailsController.class);
		
		router.addRoute(END, null);

		Response prevController = new Response(App.START, new Request());
		
		while (prevController.getRouting() != END) {

			Controller nextController = router.getRoute(prevController.getRouting());
			nextController.setRequest(prevController.getReq());
			prevController = nextController.doDisplay();

		}

	}

}