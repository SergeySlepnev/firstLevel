package mentoring.levelone.javacoreleveltwo.inheritance;

public class Star extends SphericalSpaceObject {

    private double temperature;

    public Star(String name) {
        super(name);
    }

    public Star(String name, Coordinate center) {
        super(name, center);
    }

    public Star(String name, Coordinate center, double radius, double temperature) {
        super(name, center, radius);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
