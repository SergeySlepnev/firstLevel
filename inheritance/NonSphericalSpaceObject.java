package mentoring.levelone.javacoreleveltwo.inheritance;

public abstract class NonSphericalSpaceObject extends SpaceObject implements Computable{

    private double width;
    private double height;

    public NonSphericalSpaceObject(String name) {
        super(name);
    }

    public NonSphericalSpaceObject(String name, Coordinate center) {
        super(name, center);
    }

    public NonSphericalSpaceObject(String name, Coordinate center, double width, double height) {
        super(name, center);
        this.width = width;
        this.height = height;
    }
    @Override
    public double countMass() {
        return 0;
    }
    @Override
    public double countSpeed() {
        return 0;
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
