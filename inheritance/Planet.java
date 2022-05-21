package mentoring.levelone.javacoreleveltwo.inheritance;

public class Planet extends SphericalSpaceObject {

    private boolean hasSatellite;
    private boolean hasRings;
    private Satellite[] satellites;

    public Planet(String name) {
        super(name);
    }

    public Planet(String name, Coordinate center) {
        super(name, center);
    }

    public Planet(String name, Coordinate center, double radius, boolean hasSatellite, boolean hasRings) {
        super(name, center, radius);
        this.hasSatellite = hasSatellite;
        this.hasRings = hasRings;
    }

     public int countSatellite() {
        return satellites.length;
    }

    public double countMassOfSatellite() {
        double mass = 0;
        for (Satellite satellite : satellites) {
            mass += satellite.countMass();
        }
        return mass;
    }

    public boolean isHasSatellite() {
        return hasSatellite;
    }

    public void setHasSatellite(boolean hasSatellite) {
        this.hasSatellite = hasSatellite;
    }

    public boolean isHasRings() {
        return hasRings;
    }

    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public Satellite[] getSatellites() {
        return satellites;
    }

    public void setSatellites(Satellite[] satellites) {
        this.satellites = satellites;
    }
}
