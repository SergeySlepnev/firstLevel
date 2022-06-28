package mentoring.levelone.javacoreleveltwo.regex.service;

import mentoring.levelone.javacoreleveltwo.regex.util.RandomUtils;
import mentoring.levelone.javacoreleveltwo.regex.util.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class IncomingCall extends Thread {

    public static final BlockingQueue<IncomingCall> incomingCalls = new ArrayBlockingQueue<>(50);

    private final String phoneNumber;

    public IncomingCall() {
        this.phoneNumber = RandomUtils.randomPhoneNumber();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("New incoming call...");
                IncomingCall incomingCall = new IncomingCall();
                incomingCalls.put(incomingCall);
                Thread.sleep(ThreadUtils.INCOMING_CALL_PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String phoneNumber() {
        return phoneNumber;
    }
}