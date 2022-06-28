package mentoring.levelone.javacoreleveltwo.regex.service;

import mentoring.levelone.javacoreleveltwo.regex.model.logResources.HandledComplaintRow;
import mentoring.levelone.javacoreleveltwo.regex.model.logResources.NewComplaintRow;
import mentoring.levelone.javacoreleveltwo.regex.util.FormatUtils;
import mentoring.levelone.javacoreleveltwo.regex.util.IOConst;
import mentoring.levelone.javacoreleveltwo.regex.util.ThreadUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public enum SupportDispatcher implements Runnable {
    FEDOR("Fedor"),
    VERA("Vera"),
    KIRILL("Kirill"),
    PAVEL("Pavel");

    public static final List<SupportDispatcher> SUPPORT_DISPATCHERS = Arrays.asList(values());
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    private static ScheduledFuture<BlockingQueue<NewComplaintRow>> lastLogs;
    private final String name;

    SupportDispatcher(String name) {
        Thread.currentThread().setName(name);
        this.name = name;
    }

    //на самом деле этот метод ничего не обновляет, а просто один раз возвращает
    //ScheduledFuture<BlockingQueue<NewComplaintRow>> спустя READ_NEW_COMPLAINTS_PERIOD
    // я не нашёл способа, чтобы запускать Callable через определённый период. Может плохо искал)
    public static void renewLastLogs() {
            lastLogs = service.schedule(new ComplaintLogJob(), ThreadUtils.READ_NEW_COMPLAINTS_PERIOD, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        while (true) {
            try {
                NewComplaintRow log = lastLogs.get().take();
                HandledComplaintRow convert = convert(log);
                System.out.println(getName() + " is handling complaint #" + log.getId());
                Files.writeString(IOConst.handledComplaintPath, convert.getStringValue() + '\n', StandardOpenOption.APPEND, StandardOpenOption.SYNC);
                Thread.sleep(ThreadUtils.handlingTime());
                System.out.println(getName() + " is waiting for new a new complaint.");
            } catch (IOException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private HandledComplaintRow convert(NewComplaintRow complaintLog) {
        String data = complaintLog.getStringValue();
        String dateTime = FormatUtils.formatDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        String phoneNumber = FormatUtils.findAndFormatPhoneNumber(data);
        return new HandledComplaintRow(complaintLog.getId(), dateTime, phoneNumber);
    }

    public String getName() {
        return name;
    }
}