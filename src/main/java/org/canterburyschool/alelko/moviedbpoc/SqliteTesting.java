package org.canterburyschool.alelko.moviedbpoc;

import java.io.InputStream;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.canterburyschool.alelko.moviedbpoc.service.MovieDBSQLiteService;

public class SqliteTesting {

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

	public static void main(String[] args) throws Exception {

		LOG.debug("Starting Service");
		Connection conn = null;

		try {
			LOG.debug("Working directory = " + System.getProperty("user.dir"));

			final String url = "jdbc:sqlite:src/main/resources/movie.db";
			conn = DriverManager.getConnection(url);
			LOG.debug("Connection Good");

			LOG.debug("Creating Statement");
			final Statement statement = conn.createStatement();

			String createString = "insert into movies (id, title, imdb_id) values (5, 'The Dark Knight', 'tt0017') ";
			String retrieveString = "select id, title, imdb_id from movies ";
			String updateString = "update movies set imdb_id = 'tt0018' ";
			String delectString = "delete from movies ";
			StringBuilder sb = new StringBuilder("select * from mpaa_ratings;");
//			sb.append("where id = ");
//			sb.append(5);
			final String sql = sb.toString();

			LOG.debug("Executing query");
			final ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				LOG.info(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
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
	}
}
