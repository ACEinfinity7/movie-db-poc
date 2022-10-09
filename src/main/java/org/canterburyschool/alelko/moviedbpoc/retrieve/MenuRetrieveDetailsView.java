package org.canterburyschool.alelko.moviedbpoc.retrieve;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.Session;

public class MenuRetrieveDetailsView {

	private static final Logger LOG = LogManager.getLogger(MenuRetrieveDetailsView.class);

	private Scanner scanner = new Scanner(System.in);
	private int id;

	public MenuRetrieveDetailsView() {
		super();
	}

	public void display() {
		System.out.print("Enter movie id (or -1 to quit): ");
		id = scanner.nextInt();

	}
	
	public int getId() {
		return id;
	}
}
