package mentoring.levelone.javacoreleveltwo.regex.service;

import mentoring.levelone.javacoreleveltwo.regex.model.Complaint;
import mentoring.levelone.javacoreleveltwo.regex.model.logResources.LogRow;
import mentoring.levelone.javacoreleveltwo.regex.model.logResources.NewComplaintRow;
import mentoring.levelone.javacoreleveltwo.regex.util.IOConst;
import mentoring.levelone.javacoreleveltwo.regex.util.ThreadUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public enum CallCenterOperator implements Runnable {

    SASHA("Sasha"),
    ELENA("Elena"),
    MICHAIL("Michail"),
    ANDREY("Andrey");

    public static final List<CallCenterOperator> CALL_CENTER_OPERATORS = Arrays.asList(values());
    public final String name;

    CallCenterOperator(String name) {
        Thread.currentThread().setName(name);
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                IncomingCall newIncomingCall = IncomingCall.incomingCalls.take();
                handleIncomingCall(newIncomingCall);
                System.out.println(getName() + " is handling incoming call from " + newIncomingCall.phoneNumber());
                Thread.sleep(ThreadUtils.handlingTime());
                System.out.println("The call was handled.");
                System.out.println(getName() + " is waiting for a new call...");
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleIncomingCall(IncomingCall call) throws IOException, InterruptedException {
        Complaint complaint = Complaint.createNewComplaint(call);
        NewComplaintRow complaintRecord = createComplaintRecord(complaint);
        writeToLog(complaintRecord);
    }

    public NewComplaintRow createComplaintRecord(Complaint complaint) throws InterruptedException {
        NewComplaintRow record = new NewComplaintRow(
                complaint.getId(),
                complaint.getDateTime(),
                complaint.getLastName(),
                complaint.getFirstName(),
                complaint.getPhoneNumber(),
                complaint.getContent());
        NewComplaintRow.addToQueue(record);
        return record;
    }

    public static void writeToLog(LogRow row) throws IOException {
        Files.writeString(IOConst.newComplaintPath, row.getStringValue() + '\n', StandardOpenOption.APPEND, StandardOpenOption.SYNC);
    }

    public static int numberOfOperators() {
        return values().length;
    }

    public String getName() {
        return name;
    }
}