package org.canterburyschool.alelko.moviedbpoc.update;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MovieDBUpdateView {
	private static final Logger LOG = LogManager.getLogger(MovieDBUpdateView.class);
	
	private int idOld;
	private String titleOld;
	private String imdbIdOld;
	
	private int idNew;
	private String titleNew;
	private String imdbIdNew;
	
	public MovieDBUpdateView() {
		super();
	}
	
	public void display() {
		System.out.printf("Entry with information > Id: %d | Title: %s | Imdb Id: %s %n", idOld, titleOld, imdbIdOld);
		
		System.out.printf("Has been updated to > Id: %d | Title: %s | Imdb Id: %s %n", idNew, titleNew, imdbIdNew);
		
		
	}
}
