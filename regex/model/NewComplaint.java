package regex.model;


import regex.utils.RandomUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NewComplaint {

    private static int complaintIdGenerator = 1;

    private final int id;
    private final String dateTime;
    private final String lastName;
    private final String firstName;
    private final String phoneNumber;
    private final String content;

    private NewComplaint(IncomingCall call) {
        this.id = complaintIdGenerator++;
        this.dateTime = String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        this.lastName = RandomUtils.randomLastName();
        this.firstName = RandomUtils.randomFirstName();
        this.phoneNumber = call.phoneNumber();
        this.content = RandomUtils.randomContent();
    }

    public static NewComplaint createNewComplaint(IncomingCall call) {
        return new NewComplaint(call);
    }

    public int getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getContent() {
        return content;
    }
}