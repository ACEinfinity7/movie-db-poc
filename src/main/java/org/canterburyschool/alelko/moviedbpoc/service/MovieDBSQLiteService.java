package org.canterburyschool.alelko.moviedbpoc.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.dto.MovieDTO;
import org.canterburyschool.alelko.moviedbpoc.dto.RatingDTO;

public class MovieDBSQLiteService implements MovieDBService {
	private static final Logger LOG = LogManager.getLogger(MovieDBSQLiteService.class);
	private static final String PROP_FILE = "db.properties";

	private String db = "";
	private String uid = "";
	private String password = "";

	static {
		final Properties props = new Properties();

		try {
			final InputStream is = ClassLoader.getSystemResourceAsStream(PROP_FILE);
			props.load(is);
		} catch (Exception e) {
			System.out.print("error: " + e);
			e.printStackTrace();
		}
	}

	public MovieDBSQLiteService() {
		super();
	}

	public MovieDTO createMovie(String title, String imdbId, int runTime, int mpaaRatingId) {
		LOG.debug("Starting Service");
		Connection conn = null;
		MovieDTO dto = new MovieDTO();

		StringBuilder sb = new StringBuilder();
		sb.append("insert into movies (title, imdb_id, run_time, mpaa_rating_id) values ('");
		sb.append(title).append("', '");
		sb.append(imdbId).append("', ");
		sb.append(runTime).append(", ");
		sb.append(mpaaRatingId).append(")");

		String query = sb.toString();
		LOG.debug(query);

		try {
			LOG.debug("Working directory = " + System.getProperty("user.dir"));

			final String url = "jdbc:sqlite:src/main/resources/movie.db";
			conn = DriverManager.getConnection(url);
			LOG.debug("Connection Good");

			LOG.debug("Creating Statement");
			final Statement statement = conn.createStatement();

			LOG.debug("Executing Insert query");
			statement.executeUpdate(query);
			
			LOG.debug("Getting new id");
			final ResultSet idGetter = statement.executeQuery("select last_insert_rowid()");
			int id = idGetter.getInt(1);
			
			LOG.debug(id);

			LOG.debug("Executing Select query");
			final ResultSet rs = statement.executeQuery(
					"select id, title, imdb_id, run_time, mpaa_ratings.mpaa_rating_id, rating, description, min_age from movies inner join mpaa_ratings where movies.mpaa_rating_id = mpaa_ratings.mpaa_rating_id and id = "
							+ String.valueOf(id));
			
			RatingDTO ratingInfo = new RatingDTO(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			
			dto = new MovieDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), ratingInfo);

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());

			}
		}
		return dto;
	}

	public MovieDTO retrieveMovie(int id) {
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

	public MovieDTO doGo(String query) throws Exception {
		LOG.debug("Starting Service");
		Connection conn = null;
		MovieDTO dto = new MovieDTO();

		StringBuilder sb = new StringBuilder();

		try {
			LOG.debug("Working directory = " + System.getProperty("user.dir"));

			final String url = "jdbc:sqlite:src/main/resources/movie.db";
			conn = DriverManager.getConnection(url);
			LOG.debug("Connection Good");

			LOG.debug("Creating Statement");
			final Statement statement = conn.createStatement();

			LOG.debug("Executing query");
			final ResultSet rs = statement.executeQuery(query);

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());

			}
		}
		return dto;

	}

	public List<RatingDTO> getMpaaRatingInfo() throws Exception {
		List<RatingDTO> ratings = new ArrayList<RatingDTO>();

		LOG.debug("Starting Service");
		Connection conn = null;

		final String query = "select * from mpaa_ratings";

		try {
			LOG.debug("Working directory = " + System.getProperty("user.dir"));

			final String url = "jdbc:sqlite:src/main/resources/movie.db";
			conn = DriverManager.getConnection(url);
			LOG.debug("Connection Good");

			LOG.debug("Creating Statement");
			final Statement statement = conn.createStatement();

			LOG.debug("Executing Select query");
			final ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				ratings.add(new RatingDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());

			}
		}

		return ratings;
	}

	public static void main(String[] args) throws Exception {
		MovieDBServiceFactory.SERVICE_TYPE = ServiceType.SQLITE;
//		List<RatingDTO> ratings = MovieDBServiceFactory.getService().getMpaaRatingInfo();
//		for (RatingDTO rating : ratings) {
//			System.out.println(rating.getDescription());
//		}

		System.out.print(MovieDBServiceFactory.getService().createMovie("test", "ttzzzz", 666, 1));
	}

}
