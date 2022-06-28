package mentoring.levelone.javacoreleveltwo.regex.model.logResources;

import mentoring.levelone.javacoreleveltwo.regex.util.FormatUtils;

import java.util.List;

public enum LogType {
    NEW_COMPLAINTS_LOG("newComplaints.csv", "Client_ID", "Date_Time", "LastName", "FirstName", "PhoneNumber", "Complaint"),
    HANDLED_COMPLAINTS_LOG("handledComplaints.csv", "Client_ID", "Date_Time", "PhoneNumber");

    private final String logFileName;
    private final List<String> headers;

    LogType(String logFileName, String... headers) {
        this.logFileName = logFileName;
        this.headers = List.of(headers);
    }

    public String getFileName() {
        return logFileName;
    }

    public String getHeaders() {
        return String.join(FormatUtils.COMMA, headers);
    }
}