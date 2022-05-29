package dmdev.mentoring.levelone.coreleveltwo.homework.collections.parttwo.movie;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Getter
public class MovieTheater {

    private static final String NO_MOVIES_FOUND = "NO MOVIES FOUND";
    private static final int TOP_INDEX = 10;

    private TreeMap<Integer, ArrayList<Movie>> movies;

    public void addMovie(Movie movie) {
        if (movies == null) {
            movies = new TreeMap<>();
            add(movie);
        } else if (movies.get(movie.getReleaseYear()) == null) {
            add(movie);
        } else {
            if (isNotContains(movie)) {
                ArrayList<Movie> movieList = movies.get(movie.getReleaseYear());
                movieList.add(movie);
                movies.putIfAbsent(movie.getReleaseYear(), movieList);
            }
        }
    }

    public ArrayList<Movie> getMoviesForYear(int year) {
        if (movies == null || movies.get(year) == null) {
            System.out.println(NO_MOVIES_FOUND);//Все выводы в коде добавил для удобства. Стоит так делать?
            return new ArrayList<>(); //Написал так, чтобы не возвращать null. Это правильно?
        } else {
            return movies.get(year);
        }
    }

    public ArrayList<Movie> getMoviesForYearMonth(int year, ReleaseMonth month) {
        ArrayList<Movie> moviesForYear = getMoviesForYear(year);
        if (moviesForYear.isEmpty()) {
            System.out.println(NO_MOVIES_FOUND);
            return moviesForYear;
        }
        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : moviesForYear) {
            if (movie.getReleaseMonth() == month) {
                result.add(movie);
            }
        }
        if (result.isEmpty()) {
            System.out.println(NO_MOVIES_FOUND);
        }
        return result;
    }

    public ArrayList<Movie> getMoviesByGenre(Genre genre) {
        ArrayList<Movie> result = new ArrayList<>();
        if (movies == null) {
            System.out.println(NO_MOVIES_FOUND);
            return result;
        }
        for (Integer key : movies.keySet()) {
            for (Movie movie : movies.get(key)) {
                if (movie.getGenre() == genre) {
                    result.add(movie);
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println(NO_MOVIES_FOUND);
        }
        return result;
    }

    //Этот метод возвращает List<Movies> вместо логичного ArrayList<Movies>
    //Я это сделал, чтобы не создавть дополнительный ArrayList.
    //Это нормальный вариант или лучше создать новый ArrayList и скопировать в него первые 10 элементов?
    public List<Movie> getTopTen() {
        ArrayList<Movie> result = new ArrayList<>();
        if (movies == null) {
            System.out.println(NO_MOVIES_FOUND);
            return result;
        }
        for (Integer key : movies.keySet()) {
            result.addAll(movies.get(key));
        }
        result.sort(new MovieRatingComparator());
        if (result.size() < 10) return result; //допускается так писать, если после условния только return?
        return result.subList(0, 10);
    }

    private void add(Movie movie) {
        if (isNotContains(movie)) {
            ArrayList<Movie> movieList = new ArrayList<>();
            movieList.add(movie);
            movies.put(movie.getReleaseYear(), movieList);
        }
    }

    private boolean isNotContains(Movie movie) {
        for (ArrayList<Movie> value : movies.values()) {
            if (value.contains(movie)) {
                System.out.printf("THE MOVIE WITH ID#%d IS ALREADY IN MOVIE THEATER \n", movie.getId());
                return false;
            }
        }
        return true;
    }
}
