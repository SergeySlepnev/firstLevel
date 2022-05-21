package mentoring.levelone.javacoreleveltwo.inheritance;

public class SpaceObjectRunner {
    public static void main(String[] args) {
        SpaceObject asteroid = new Asteroid("One", new Coordinate(10, 4));
        SpaceObject planet = new Planet("Earth",new Coordinate(1,3));
        Star[] stars = new Star[]{new Star("First stars"), new Star("Second star"), new Star("Third star")};
        SpaceObject constellation = new Constellation("Constellation", new Coordinate(10, 20), stars);
        double distance = asteroid.distance(planet);
        System.out.println(distance);
        double distance1 = constellation.distance(planet);
        System.out.println("distance1 = " + distance1);
    }
}
