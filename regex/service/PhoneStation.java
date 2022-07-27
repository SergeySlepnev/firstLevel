package regex.service;

import regex.model.IncomingCall;
import regex.utils.ThreadUtils;

import java.util.concurrent.BlockingQueue;

public class PhoneStation implements Runnable {

    private final BlockingQueue<IncomingCall> calls;

    public PhoneStation(BlockingQueue<IncomingCall> calls) {
        this.calls = calls;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("New incoming call...");
                IncomingCall call = new IncomingCall();
                calls.put(call);
                Thread.sleep(ThreadUtils.INCOMING_CALL_PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}