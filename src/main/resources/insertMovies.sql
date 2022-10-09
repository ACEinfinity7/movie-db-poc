DROP TABLE IF EXISTS mpaa_ratings;
DROP TABLE IF EXISTS movies;

CREATE TABLE mpaa_ratings(
        mpaa_rating_id INTEGER PRIMARY KEY,
        rating TEXT,
        description TEXT,
        min_age INTEGER

);

CREATE TABLE movies(
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        title TEXT,
        imdb_id TEXT,
        run_time INTEGER,
        mpaa_rating_id INTEGER,
        FOREIGN KEY(mpaa_rating_id) REFERENCES mpaa_ratings(id)
);



 INSERT INTO mpaa_ratings (mpaa_rating_id, rating, description, min_age) VALUES (1, 'G', 'For General Audiences', 0);
 INSERT INTO mpaa_ratings (mpaa_rating_id, rating, description, min_age) VALUES (2, 'PG', 'Parental Guidance Suggested', 0);
 INSERT INTO mpaa_ratings (mpaa_rating_id, rating, description, min_age) VALUES (3, 'PG-13', 'Parents Strongly Cautioned, Some material may be inappropriate for children under 13', 13);
 INSERT INTO mpaa_ratings (mpaa_rating_id, rating, description, min_age) VALUES (4, 'R', 'Under 17 must be accompanied by adult, film contains some adult content', 18);
 INSERT INTO mpaa_ratings (mpaa_rating_id, rating, description, min_age) VALUES (5, 'NC-17', 'No one under the age of 17 can be admitted to the film', 18);


INSERT INTO movies (title, imdb_id, run_time, mpaa_rating_id) VALUES ('The Fellowship of the Ring', 'tt0011', '228', 3);
INSERT INTO movies (title, imdb_id, run_time, mpaa_rating_id) VALUES ('The Two Towers', 'tt0012', '235', 3);
INSERT INTO movies (title, imdb_id, run_time, mpaa_rating_id) VALUES ('The Return of the King', 'tt0013', '263', 3);
