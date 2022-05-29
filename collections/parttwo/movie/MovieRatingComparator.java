package dmdev.mentoring.levelone.coreleveltwo.homework.collections.parttwo.movie;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o2.getRating(), o1.getRating());
    }
}
