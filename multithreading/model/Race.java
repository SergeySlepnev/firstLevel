package multithreading.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static multithreading.util.CrystalConst.AMOUNT_OF_CRYSTALS;

public class Race {

    public final Map<Crystal, Integer> raceCrystals = new EnumMap<>(Crystal.class);
    private final String name;

    public Race(String name) {
        this.name = name;
        raceCrystals.put(Crystal.RED_CRYSTAL, 0);
        raceCrystals.put(Crystal.WHITE_CRYSTAL, 0);
    }

    public void addCrystals(List<Crystal> crystals) {
        crystals.forEach(crystal -> raceCrystals.merge(crystal, 1, Integer::sum));
    }

    public int amountOfRedCrystals() {
        return raceCrystals.get(Crystal.RED_CRYSTAL);
    }

    public int amountOfWhiteCrystals() {
        return raceCrystals.get(Crystal.WHITE_CRYSTAL);
    }

    public boolean isNotEnoughCrystals() {
        return !(amountOfRedCrystals() >= AMOUNT_OF_CRYSTALS &&
                amountOfWhiteCrystals() >= AMOUNT_OF_CRYSTALS);
    }

    public String getName() {
        return name;
    }

    public void viewStatistics() {
        System.out.println(getName() + " gathered " + amountOfRedCrystals() + " red crystals and " + amountOfWhiteCrystals() + " white crystals.");
    }
}