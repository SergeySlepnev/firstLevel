package mentoring.levelone.javacoreleveltwo.regex.util;

import mentoring.levelone.javacoreleveltwo.regex.model.logResources.LogType;

import java.nio.file.Path;

public final class IOConst {

    private IOConst() {
    }

    private static final String RESOURCE_DIR = "resources";
    public static final Path newComplaintPath = Path.of(RESOURCE_DIR, LogType.NEW_COMPLAINTS_LOG.getFileName());
    public static final Path handledComplaintPath = Path.of(RESOURCE_DIR, LogType.HANDLED_COMPLAINTS_LOG.getFileName());

}