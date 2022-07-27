package regex.service;

import regex.utils.FormatUtils;
import regex.utils.IOConst;
import regex.utils.ThreadUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupportTeam implements Runnable {

    public static final int NUMBERS_OF_DISPATCHERS = 3;

    private final ExecutorService executorService;
    private final BlockingQueue<String> logRows;

    public SupportTeam(BlockingQueue<String> logRows) {
        this.logRows = logRows;
        this.executorService = Executors.newFixedThreadPool(NUMBERS_OF_DISPATCHERS);
    }

    @Override
    public void run() {
        while (true) {
            executorService.execute(this::handleComplaint);
        }
    }

    private void handleComplaint() {
        try {
            var lastRecord = logRows.take();
            System.out.println("Support team is handling complaint #" + lastRecord.substring(0, lastRecord.indexOf(FormatUtils.COMMA)));
            Files.writeString(IOConst.HANDLED_COMPLAINT_PATH, lastRecord + '\n', StandardOpenOption.APPEND, StandardOpenOption.SYNC);
            Thread.sleep(ThreadUtils.handlingTime());
            System.out.println("Support team is waiting for new a new complaint.");
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}