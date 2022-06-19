package multithreading;

import multithreading.thread.Day;
import multithreading.thread.PlanetDay;
import multithreading.thread.Rocket;
import multithreading.util.TreadUtils;
import multithreading.model.Planet;
import multithreading.model.Race;

public class RaceRunner {

    public static void main(String[] args) throws InterruptedException {
        Race fireMagicians = new Race("Fire magicians");
        Race airMagicians = new Race("Air magicians");
        Day day = new Day(fireMagicians, airMagicians);
        Planet planet = new Planet();
        PlanetDay planetDay = new PlanetDay(planet, day);
        Rocket fireMageRocket = new Rocket(day, fireMagicians, planet);
        Rocket airMageRocket = new Rocket(day, airMagicians, planet);

        TreadUtils.startThreads(day, planetDay, fireMageRocket, airMageRocket);
        TreadUtils.joinThreads(day, planetDay, fireMageRocket, airMageRocket);
    }
}