package mentoring.levelone.javacoreleveltwo.inheritance;

public class Asteroid extends NonSphericalSpaceObject {

    private double distanceToSun;

    public Asteroid(String name) {
        super(name);
    }

    public Asteroid(String name, Coordinate center) {
        super(name, center);
    }

    public Asteroid(String name, Coordinate center, double distanceToSun) {
        super(name, center);
        this.distanceToSun = distanceToSun;
    }

    public Asteroid(String name, Coordinate center, double width, double height) {
        super(name, center, width, height);
    }

    public double getDistanceToSun() {
        return distanceToSun;
    }

    public void setDistanceToSun(double distanceToSun) {
        this.distanceToSun = distanceToSun;
    }
}
