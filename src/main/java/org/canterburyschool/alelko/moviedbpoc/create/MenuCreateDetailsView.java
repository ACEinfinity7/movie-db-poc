package org.canterburyschool.alelko.moviedbpoc.create;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuCreateDetailsView {
	private static final Logger LOG = LogManager.getLogger(MenuCreateDetailsView.class);
	
	private Scanner scanner;
	private int id;
	private String title;
	private String imdbId;
	
	public MenuCreateDetailsView() {
		super();
		
		scanner = new Scanner(System.in);
	}
	
	public void display() {
		System.out.print("Enter id of new movie: ");
		id = scanner.nextInt();
		
		System.out.print("Enter title of new movie: ");
		title = scanner.nextLine();
		
		System.out.print("Enter imdb id of new movie: ");
		imdbId = scanner.nextLine();
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getImdbId() {
		return imdbId;
	}
	
	
}
