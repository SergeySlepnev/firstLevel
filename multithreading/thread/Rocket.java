package multithreading.thread;

import multithreading.model.Crystal;
import multithreading.model.Planet;
import multithreading.model.Race;
import multithreading.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import static multithreading.util.CrystalConst.MAX_CRYSTALS;
import static multithreading.util.CrystalConst.MIN_CRYSTALS;

public class Rocket extends Thread {

    private final Day day;
    private final Race race;
    private final Planet planet;

    public Rocket(Day day, Race race, Planet planet) {
        this.day = day;
        this.race = race;
        this.planet = planet;
    }

    @Override
    public void run() {
        try {
            while (day.getFirstRace().isNotEnoughCrystals() && day.getSecondRace().isNotEnoughCrystals()) {
                List<Crystal> gatheredCrystals = gatherCrystalsFromPlanet();
                race.addCrystals(gatheredCrystals);
                race.viewStatistics();
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Crystal> gatherCrystalsFromPlanet() {
        int amountCrystalsGatheredFromPlanet = RandomUtils.getNextWithinBounds(MIN_CRYSTALS, MAX_CRYSTALS);
        List<Crystal> gatheredCrystals = new ArrayList<>(MAX_CRYSTALS);
        synchronized (planet.getLock()) {
            if (planet.amountCrystalsPerDay() <= amountCrystalsGatheredFromPlanet) {
                gatheredCrystals.addAll(planet.removeAll());
            } else if (planet.isNotEmpty()) {
                for (int i = 0; i < amountCrystalsGatheredFromPlanet; i++) {
                    Crystal removedCrystal = planet.remove(RandomUtils.getNext(planet.amountCrystalsPerDay()));
                    gatheredCrystals.add(removedCrystal);
                }
            }
        }
        System.out.println(getRace().getName() + "'s rocket gathered " + gatheredCrystals.size() + " crystals.");
        return gatheredCrystals;
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }

    public Race getRace() {
        return race;
    }
}