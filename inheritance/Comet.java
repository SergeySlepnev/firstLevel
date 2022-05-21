package mentoring.levelone.javacoreleveltwo.inheritance;

public class Comet extends NonSphericalSpaceObject {

    public Comet(String name) {
        super(name);
    }

    public Comet(String name, Coordinate center) {
        super(name, center);
    }

    public Comet(String name, Coordinate center, double width, double height) {
        super(name, center, width, height);
    }

    public double countLengthOfTail() {
        return 0;
    }
}
