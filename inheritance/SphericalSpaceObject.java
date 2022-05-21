package mentoring.levelone.javacoreleveltwo.inheritance;

public abstract class SphericalSpaceObject extends SpaceObject implements Spherical, Computable {

    private double radius;

    public SphericalSpaceObject(String name) {
        super(name);
    }
    public SphericalSpaceObject(String name, Coordinate center) {
        super(name, center);
    }

    public SphericalSpaceObject(String name, Coordinate center, double radius) {
        super(name, center);
        this.radius = radius;
    }

    @Override
    public double countVolume() {
        return 0;
    }

    @Override
    public double countArea() {
        return 0;
    }

    @Override
    public double countMass() {
        return 0;
    }
    @Override
    public double countSpeed() {
        return 0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
