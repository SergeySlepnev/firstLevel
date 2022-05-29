package dmdev.mentoring.levelone.coreleveltwo.homework.collections.parttwo.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static dmdev.mentoring.levelone.coreleveltwo.homework.collections.parttwo.movie.Genre.*;
import static dmdev.mentoring.levelone.coreleveltwo.homework.collections.parttwo.movie.ReleaseMonth.*;

public class MovieTheaterRunner {

    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.addMovie(new Movie(1, 2018, DECEMBER, COMEDY, 100));
        movieTheater.addMovie(new Movie(2, 2021, NOVEMBER, HORROR, 80));
        movieTheater.addMovie(new Movie(3, 2022, APRIL, ACTION_MOVIE, 94));
        movieTheater.addMovie(new Movie(4, 2018, SEPTEMBER, ACTION_MOVIE, 87));
        movieTheater.addMovie(new Movie(5, 2020, JULY, FAMILY, 56));
        movieTheater.addMovie(new Movie(6, 2020, AUGUST, FANTASY, 77));
        movieTheater.addMovie(new Movie(7, 2019, OCTOBER, CARTOON, 34));
        movieTheater.addMovie(new Movie(8, 2017, FEBRUARY, FANTASY, 57));
        movieTheater.addMovie(new Movie(9, 2016, MAY, COMEDY, 79));
        movieTheater.addMovie(new Movie(10, 2016, MAY, COMEDY, 89));
        movieTheater.addMovie(new Movie(11, 2021, JANUARY, HORROR, 52));
        movieTheater.addMovie(new Movie(12, 2022, JUNE, ACTION_MOVIE, 77));
        movieTheater.addMovie(new Movie(12, 2010, MAY, DRAMA, 53));
        TreeMap<Integer, ArrayList<Movie>> movies = movieTheater.getMovies();
        ArrayList<Movie> moviesForYear = movieTheater.getMoviesForYear(2017);
        ArrayList<Movie> moviesForYearMonth = movieTheater.getMoviesForYearMonth(2016, MAY);
        ArrayList<Movie> moviesByGenre = movieTheater.getMoviesByGenre(ACTION_MOVIE);
        List<Movie> topTen = movieTheater.getTopTen();
    }
}


