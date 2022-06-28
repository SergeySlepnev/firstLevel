package mentoring.levelone.javacoreleveltwo.regex.model;

import mentoring.levelone.javacoreleveltwo.regex.service.CallCenterOperator;
import mentoring.levelone.javacoreleveltwo.regex.service.IncomingCall;
import mentoring.levelone.javacoreleveltwo.regex.util.RandomUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Complaint {

    private static int complaintIdGenerator = 1;
    private static final BlockingQueue<Complaint> complaints = new ArrayBlockingQueue<>(CallCenterOperator.numberOfOperators() * 20);

    private final int id;
    private final String dateTime;
    private final String lastName;
    private final String firstName;
    private final String phoneNumber;
    private final String content;

    public static Complaint createNewComplaint(IncomingCall call) {
        Complaint complaint = new Complaint(call);
        complaints.add(complaint);
        return complaint;
    }

    private Complaint(IncomingCall call) {
        this.id = complaintIdGenerator++;
        this.dateTime = String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        this.lastName = RandomUtils.randomLastName();
        this.firstName = RandomUtils.randomFirstName();
        this.phoneNumber = call.phoneNumber();
        this.content = RandomUtils.randomContent();
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