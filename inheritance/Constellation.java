package mentoring.levelone.javacoreleveltwo.inheritance;

public class Constellation extends SpaceObject {

    private Star[] stars;

    public Constellation(String name) {
        super(name);
    }
    public Constellation(String name, Coordinate center) {
        super(name, center);
    }
    public Constellation(String name, Coordinate center, Star[] stars) {
        super(name, center);
        this.stars = stars;
    }
    public int countStars() {
        return stars.length;
    }

    public Star[] getStars() {
        return stars;
    }
    public void setStars(Star[] stars) {
        this.stars = stars;
    }
}
