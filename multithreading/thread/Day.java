package multithreading.thread;

import multithreading.model.Race;

public class Day extends Thread {

    private static final long DAY_DURATION = 50L;

    private final Object lock = new Object();
    private final Race firstRace;
    private final Race secondRace;

    public Day(Race firstRace, Race secondRace) {
        this.firstRace = firstRace;
        this.secondRace = secondRace;
    }

    @Override
    public void run() {
        int day = 1;
        synchronized (lock) {
            while (firstRace.isNotEnoughCrystals() && secondRace.isNotEnoughCrystals()) {
                try {
                    System.out.println("---------------------");
                    System.out.println("Day " + (day++) + " is started.");
                    lock.notifyAll();
                    lock.wait(DAY_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }

    public Race getFirstRace() {
        return firstRace;
    }

    public Race getSecondRace() {
        return secondRace;
    }
}