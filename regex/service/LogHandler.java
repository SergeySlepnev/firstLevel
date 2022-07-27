package regex.service;

import regex.utils.FormatUtils;
import regex.utils.IOConst;

import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.BlockingQueue;

public class LogHandler implements Runnable {

    private final static int HEADER_RECORD = 1;
    private static int LAST_RECORD;
    private final static int ID_INDEX = 0;
    private final static int DATE_TIME_INDEX = 1;
    private final static int PHONE_INDEX = 4;

    private final BlockingQueue<String> logRecords;

    public LogHandler(BlockingQueue<String> logRecords) {
        this.logRecords = logRecords;
    }

    @Override
    public void run() {
        mapLogRecord();
    }

    public void mapLogRecord() {
        try (var rows = Files.lines(IOConst.NEW_COMPLAINT_PATH)) {
            rows.skip(LAST_RECORD + HEADER_RECORD)
                    .map(row -> row.split(FormatUtils.COMMA))
                    .map(strings -> {
                        var mappedLogRecord = String.join(
                                FormatUtils.COMMA,
                                strings[ID_INDEX],
                                FormatUtils.findAndFormatDateTime(strings[DATE_TIME_INDEX]),
                                FormatUtils.findAndFormatPhoneNumber(strings[PHONE_INDEX]));
                        LAST_RECORD++;
                        return mappedLogRecord;
                    })
                    .forEach(logRecords::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}