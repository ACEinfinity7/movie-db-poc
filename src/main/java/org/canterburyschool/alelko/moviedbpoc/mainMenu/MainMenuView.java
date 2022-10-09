package org.canterburyschool.alelko.moviedbpoc.mainMenu;

import java.util.Scanner;

import org.canterburyschool.alelko.moviedbpoc.Session;

public class MainMenuView {
	private Scanner scanner = new Scanner(System.in);
	
	private int action;

	public MainMenuView() {
		super();
	}

	public void display() {
		System.out.print("Enter action: 1 for Create, 2 for Retrieve, 3 for Update, and 4 for Delete (-1 to quit): ");
		action = scanner.nextInt();
		
	}
	
	public int getAction() {
		return action;
	}
}
