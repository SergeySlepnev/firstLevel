package mentoring.levelone.javacoreleveltwo.inheritance;

public abstract class SpaceObject implements Distancable {

    private final String name;
    private Coordinate center;

    public SpaceObject(String name) {
        this.name = name;
    }

    public SpaceObject(String name, Coordinate center) {
        this.name = name;
        this.center = center;
    }

    public double distance(SpaceObject spaceObject) {
        int firstLeg = Math.abs(center.getX() - spaceObject.center.getX());
        int secondLeg = Math.abs(center.getY() - spaceObject.center.getY());
        return Math.sqrt(Math.pow(firstLeg, 2) + Math.pow(secondLeg, 2));
    }


    public String getName() {
        return name;
    }

    public Coordinate getCenter() {
        return center;
    }
}
