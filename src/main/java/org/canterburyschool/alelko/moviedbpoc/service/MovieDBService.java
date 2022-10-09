package org.canterburyschool.alelko.moviedbpoc.service;

import java.util.List;

import org.canterburyschool.alelko.moviedbpoc.dto.MovieDTO;
import org.canterburyschool.alelko.moviedbpoc.dto.RatingDTO;

public interface MovieDBService {

	public MovieDTO createMovie(String title, String imdbId, int runTime, int mpaaRatingId) throws Exception;

	public MovieDTO retrieveMovie(int id) throws Exception;

	public MovieDTO updateMovie(int id, String title, String imdbId, int runTime, int mpaaRatingId) throws Exception;

	public MovieDTO deleteMovie(int id) throws Exception;

	public List<RatingDTO> getMpaaRatingInfo() throws Exception;

}
