package regex.service;

import regex.model.IncomingCall;
import regex.model.NewComplaint;
import regex.utils.FormatUtils;
import regex.utils.IOConst;
import regex.utils.ThreadUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.BlockingQueue;

public class CallCenterOperator implements Runnable {

    private final BlockingQueue<IncomingCall> calls;
    private final String name;

    public CallCenterOperator(String name, BlockingQueue<IncomingCall> calls) {
        this.calls = calls;
        this.name = name;
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                var call = calls.take();
                handleIncomingCall(call);
                System.out.println(getName() + " is handling incoming call from " + call.phoneNumber());
                Thread.sleep(ThreadUtils.handlingTime());
                System.out.println("The call was handled.");
                System.out.println(getName() + " is waiting for a new call...");
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleIncomingCall(IncomingCall call) throws IOException, InterruptedException {
        NewComplaint newComplaint = NewComplaint.createNewComplaint(call);
        var complaintRecord = String.join(
                FormatUtils.COMMA,
                String.valueOf(newComplaint.getId()),
                newComplaint.getDateTime(),
                newComplaint.getLastName(),
                newComplaint.getFirstName(),
                newComplaint.getPhoneNumber(),
                newComplaint.getContent());
        writeToLog(complaintRecord);
    }

    private static void writeToLog(String complaintRecord) throws IOException {
        Files.writeString(IOConst.NEW_COMPLAINT_PATH, complaintRecord + '\n', StandardOpenOption.APPEND, StandardOpenOption.SYNC);
    }

    public String getName() {
        return name;
    }
}