package org.canterburyschool.alelko.moviedbpoc.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.dto.MovieDTO;
import org.canterburyschool.alelko.moviedbpoc.dto.RatingDTO;

public class MovieDBHardCodedService implements MovieDBService {

	private static final Logger LOG = LogManager.getLogger(MovieDBHardCodedService.class);

	MovieDBHardCodedService() {

	}

	public MovieDTO retrieveMovie(int id) {

		MovieDTO dto = new MovieDTO();

		switch (id) {
		case 1:
			dto.setId(1);
			dto.setTitle("Tenet");
			dto.setImdbId("tt0001");
			break;
		case 2:
			dto.setId(2);
			dto.setTitle("The Prestige");
			dto.setImdbId("tt0002");
			break;
		case 3:
			dto.setId(3);
			dto.setTitle("Inception");
			dto.setImdbId("tt0003");
			break;
		default:
			dto.setId(-1);
			dto.setTitle("");
			dto.setImdbId("");

		}

		return dto;

	}

	public MovieDTO createMovie(int id, String title, String imdbId, int runTime, int mpaaRatingId) {
		// TODO Auto-generated method stub
		return null;
	}

	public MovieDTO updateMovie(int id, String title, String imdbId, int runTime, int mpaaRatingId) {
		// TODO Auto-generated method stub
		return null;
	}

	public MovieDTO deleteMovie(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RatingDTO> getMpaaRatingInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
