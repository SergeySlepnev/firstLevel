package multithreading.model;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    public final List<Crystal> crystalsOnPlanet = new ArrayList<>();
    private final Object lock = new Object();

    public void add(Crystal crystal) {
        crystalsOnPlanet.add(crystal);
    }

    public Crystal remove(int index) {
        return crystalsOnPlanet.remove(index);
    }

    public List<Crystal> removeAll() {
        List<Crystal> crystals = new ArrayList<>(crystalsOnPlanet);
        crystalsOnPlanet.clear();
        return crystals;
    }

    public Object getLock() {
        return lock;
    }

    public int amountCrystalsPerDay() {
        return crystalsOnPlanet.size();
    }

    public boolean isNotEmpty() {
        return !crystalsOnPlanet.isEmpty();
    }
}