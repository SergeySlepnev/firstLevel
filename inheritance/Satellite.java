package mentoring.levelone.javacoreleveltwo.inheritance;

public class Satellite extends SphericalSpaceObject {

    private boolean isNatural;

    public Satellite(String name) {
        super(name);
    }

    public Satellite(String name, Coordinate center) {
        super(name, center);
    }

    public Satellite(String name, Coordinate center, double radius) {
        super(name, center, radius);
    }

    @Override
    public double countMass() {
        return 0;
    }

    @Override
    public double countSpeed() {
        return 0;
    }

    public void setNatural(boolean natural) {
        isNatural = natural;
    }

    public boolean isNatural() {
        return isNatural;
    }
}
