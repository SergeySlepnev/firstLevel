package regex.service;

import regex.model.IncomingCall;
import regex.utils.IOConst;
import regex.utils.RandomUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.IntStream;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.util.concurrent.TimeUnit.MINUTES;
import static regex.utils.ThreadUtils.READ_NEW_COMPLAINTS_PERIOD;

public class SupportService implements Runnable {


    private final BlockingQueue<IncomingCall> calls;
    private final PhoneStation phoneStation;
    private final LogHandler logHandler;
    private final BlockingQueue<String> logRecords;
    private final List<CallCenterOperator> operators;
    private final SupportTeam supportTeam;
    private final ScheduledExecutorService threadPool;
    private final int additionalThreads = 2;

    public SupportService(int operatorsNumber) {
        this.calls = new LinkedBlockingDeque<>();
        this.logRecords = new LinkedBlockingDeque<>();
        this.phoneStation = new PhoneStation(calls);
        this.logHandler = new LogHandler(logRecords);
        this.operators = createOperators(operatorsNumber);
        this.supportTeam = new SupportTeam(logRecords);
        this.threadPool = Executors.newScheduledThreadPool(SupportTeam.NUMBERS_OF_DISPATCHERS + operatorsNumber + additionalThreads);
    }

    private List<CallCenterOperator> createOperators(int operatorsNumber) {
        return IntStream.range(0, operatorsNumber)
                .mapToObj(i -> new CallCenterOperator(RandomUtils.randomName(), calls)).toList();
    }

    @Override
    public void run() {
        try {
            writeHeaders();
            threadPool.execute(phoneStation);
            operators.forEach(threadPool::execute);
            threadPool.scheduleAtFixedRate(logHandler, READ_NEW_COMPLAINTS_PERIOD, READ_NEW_COMPLAINTS_PERIOD, MINUTES);
            threadPool.scheduleAtFixedRate(supportTeam, READ_NEW_COMPLAINTS_PERIOD, READ_NEW_COMPLAINTS_PERIOD, MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeHeaders() throws IOException {
        Files.writeString(IOConst.NEW_COMPLAINT_PATH, IOConst.NEW_COMPLAINT_HEADERS + '\n', CREATE, TRUNCATE_EXISTING);
        Files.writeString(IOConst.HANDLED_COMPLAINT_PATH, IOConst.HANDLED_COMPLAINT_HEADERS + '\n', CREATE, TRUNCATE_EXISTING);
    }
}