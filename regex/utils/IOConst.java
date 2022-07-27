package regex.utils;


import java.nio.file.Path;

public final class IOConst {

    private IOConst() {
    }

    private static final String RESOURCE_DIR = "resources";
    private static final String NEW_COMPLAINT_FILE_NAME = "newComplaints.csv";
    private static final String HANDLED_COMPLAINT_FILE_NAME = "handledComplaints.csv";
    public static final String NEW_COMPLAINT_HEADERS = String.join(FormatUtils.COMMA,"Client_ID", "Date_Time", "LastName", "FirstName", "PhoneNumber", "Complaint");
    public static final String HANDLED_COMPLAINT_HEADERS = String.join(FormatUtils.COMMA,"Client_ID", "Date_Time", "PhoneNumber");
    public static final Path NEW_COMPLAINT_PATH = Path.of(RESOURCE_DIR, NEW_COMPLAINT_FILE_NAME);
    public static final Path HANDLED_COMPLAINT_PATH = Path.of(RESOURCE_DIR, HANDLED_COMPLAINT_FILE_NAME);
}