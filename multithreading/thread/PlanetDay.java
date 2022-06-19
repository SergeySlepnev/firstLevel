package multithreading.thread;

import multithreading.model.Crystal;
import multithreading.model.Planet;
import multithreading.util.RandomUtils;

import static multithreading.util.CrystalConst.MAX_CRYSTALS;
import static multithreading.util.CrystalConst.MIN_CRYSTALS;

public class PlanetDay extends Thread {

    private final Planet planet;
    private final Day day;

    public PlanetDay(Planet planet, Day day) {
        this.planet = planet;
        this.day = day;
    }

    @Override
    public void run() {
        try {
            while (day.getFirstRace().isNotEnoughCrystals() && day.getSecondRace().isNotEnoughCrystals()) {
                growCrystals();
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void growCrystals() {
        int amountOfCrystalsPerDay = RandomUtils.getNextWithinBounds(MIN_CRYSTALS, MAX_CRYSTALS);
        synchronized (planet.getLock()) {
            for (int i = 0; i < amountOfCrystalsPerDay; i++) {
                Crystal crystal = Crystal.CRYSTALS.get(RandomUtils.getNext(Crystal.CRYSTALS.size()));
                planet.add(crystal);
            }
            System.out.println(amountOfCrystalsPerDay + " crystals grew on the planet during the day.");
        }
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }
}