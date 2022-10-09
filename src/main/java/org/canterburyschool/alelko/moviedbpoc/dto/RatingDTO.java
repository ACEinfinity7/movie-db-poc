package org.canterburyschool.alelko.moviedbpoc.dto;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class RatingDTO {
	private static final Logger LOG = LogManager.getLogger(RatingDTO.class);
	
	private int id;
	private String rating;
	private String description;
	private int minAge;
	
	public RatingDTO() {
		super();
	}
	
	public RatingDTO(int id, String rating, String description, int minAge) {
		super();
		
		this.id = id;
		this.rating = rating;
		this.description = description;
		this.minAge = minAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	@Override
	public String toString() {
		return "RatingDTO [id=" + id + ", rating=" + rating + ", description=" + description + ", minAge=" + minAge
				+ "]";
	}
	
	
	
	

}
