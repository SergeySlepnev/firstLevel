package dmdev.mentoring.levelone.coreleveltwo.homework.collections.parttwo.movie;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class Movie /*implements Comparable<Movie>*/ {

    private final int id;
    private final int releaseYear;
    private final ReleaseMonth releaseMonth;
    private final Genre genre;
    private int rating;

    public Movie(int id, int releaseYear, ReleaseMonth releaseMonth, Genre genre, int rating) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.genre = genre;
        this.rating = rating;
    }

  /*  @Override
    public int compareTo(Movie o) {
        return getRating() - o.getRating();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
