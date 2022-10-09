package org.canterburyschool.alelko.moviedbpoc.farewell;

public class FarewellView {

	private String username;

	public FarewellView() {
		super();
	}

	public void display() {
		System.out.println("Thank you for using Alex's Movie Database!");
	}

	public void setUserame(String username) {
		this.username = username;
	}

}
