package org.canterburyschool.alelko.moviedbpoc.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MovieDTO {

	private static final Logger LOG = LogManager.getLogger(MovieDTO.class);

	private int id;
	private String title;
	private String imdbId;
	private int runTime;
	private RatingDTO ratingInfo;

	public MovieDTO() {
		super();
	}

	public MovieDTO(int id, String title, String imdbId, int runTime, RatingDTO ratingInfo) {
		this.id = id;
		this.title = title;
		this.imdbId = imdbId;
		this.runTime = runTime;
		this.ratingInfo = ratingInfo;
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

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public RatingDTO getRatingInfo() {
		return ratingInfo;
	}

	public void setRatingInfo(RatingDTO ratingInfo) {
		this.ratingInfo = ratingInfo;
	}

	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", title=" + title + ", imdbId=" + imdbId + ", runTime=" + runTime
				+ ", ratingInfo=" + ratingInfo + "]";
	}
	
	

}
