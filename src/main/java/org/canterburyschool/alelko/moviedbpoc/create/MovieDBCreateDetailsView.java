package org.canterburyschool.alelko.moviedbpoc.create;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class MovieDBCreateDetailsView {
	private static final Logger LOG = LogManager.getLogger(MovieDBCreateDetailsView.class);
	
	private int id;
	private String title;
	private String imdbId;
	
	public MovieDBCreateDetailsView() {
		super();
	}
	
	public void display() {
		System.out.printf("A movie with Id: %d | Title: %s | Imdb Id: %s has been created %n", this.id, this.title, this.imdbId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	

}
