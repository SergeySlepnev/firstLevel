package mentoring.levelone.javacoreleveltwo.inheritance;

public final class SpaceObjectUtils {

    private SpaceObjectUtils() {
    }

    public static boolean isSpherical(SpaceObject spaceObject) {
        return spaceObject instanceof SphericalSpaceObject;
    }

    public static boolean isPlanet(SpaceObject spaceObject) {
        return spaceObject instanceof Planet;
    }

    public static boolean isSatellite(SpaceObject spaceObject) {
        return spaceObject instanceof Satellite;
    }

    public static boolean isComet(SpaceObject spaceObject) {
        return spaceObject instanceof Comet;
    }

    public static boolean isAsteroid(SpaceObject spaceObject) {
        return spaceObject instanceof Asteroid;
    }


}
