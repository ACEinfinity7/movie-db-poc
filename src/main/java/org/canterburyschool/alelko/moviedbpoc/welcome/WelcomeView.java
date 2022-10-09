package org.canterburyschool.alelko.moviedbpoc.welcome;

import java.util.Scanner;

public class WelcomeView {
	
	private Scanner scanner;
	private String username;
	
	public WelcomeView() {
		super();
		scanner = new Scanner(System.in);
	}
	
	public void display() {
		System.out.print("Welcome to Alex's Movie Database! what is your username: ");
		username = scanner.next();
	}

}
