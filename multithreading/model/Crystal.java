package multithreading.model;

import java.util.Arrays;
import java.util.List;

public enum Crystal {
    WHITE_CRYSTAL,
    RED_CRYSTAL;

    public static final List<Crystal> CRYSTALS = Arrays.asList(values());
}
