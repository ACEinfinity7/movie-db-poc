package org.canterburyschool.alelko.moviedbpoc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.dto.MovieDTO;
import org.canterburyschool.alelko.moviedbpoc.dto.RatingDTO;

public class MovieDBListService implements MovieDBService {
	private static final Logger LOG = LogManager.getLogger(MovieDBHardCodedService.class);

	private static final List<MovieDTO> MOVIES;

	static {
		MOVIES = new ArrayList<MovieDTO>();
	}

	MovieDBListService() {

	}

	public boolean createMovie(MovieDTO dto) {
		boolean inList = false;
		for (MovieDTO movie : MOVIES) {
			if (movie.equals(dto) || movie.getId() == dto.getId() || movie.getTitle() == dto.getTitle()
					|| movie.getImdbId() == dto.getTitle()) {
				inList = true;
			} else {
				MOVIES.add(dto);
			}
		}

		return !inList;
	}

	public MovieDTO retrieveMovie(int id) {
		MovieDTO toReturn = new MovieDTO();
		for (MovieDTO movie : MOVIES) {
			if (id == movie.getId()) {
				toReturn = movie;
			}
		}

		return toReturn;
	}

	public static boolean updateMovie(MovieDTO dto) {
		boolean success = false;
		for (MovieDTO movie : MOVIES) {
			if (movie.getId() == dto.getId()) {
				MOVIES.set(MOVIES.indexOf(movie), dto);
				success = true;
			}
		}

		return success;
	}

//	public boolean deleteMovie(int id) {
//		boolean success = false;
//		for (MovieDTO movie : MOVIES) {
//			if (movie.getId() == id) {
//				success = true;
//				MOVIES.remove(movie);
//			}
//
//		}
//		
//		return success;
//	}

//	ONLY USED SINCE WE DONT HAVE A REAL DATABASE
	public static void addMovie(MovieDTO movie) {
		MOVIES.add(movie);
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
