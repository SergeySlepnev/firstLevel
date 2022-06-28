package mentoring.levelone.javacoreleveltwo.regex.model.logResources;

import mentoring.levelone.javacoreleveltwo.regex.service.CallCenterOperator;
import mentoring.levelone.javacoreleveltwo.regex.util.FormatUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public record NewComplaintRow(int id,
                              String dateTime,
                              String lastName,
                              String firstName,
                              String phoneNumber,
                              String complaint) implements LogRow {

    //Правильно ли в рекорде создавать статические поля и потом с ними что-то делать?
    public static final BlockingQueue<NewComplaintRow> COMPLAINT_LOGS = new ArrayBlockingQueue<>(CallCenterOperator.numberOfOperators() * 20);

    public NewComplaintRow(String[] columns) {
        this(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);
    }

    @Override
    public String getStringValue() {
        return String.join(FormatUtils.COMMA, String.valueOf(id), dateTime, firstName, lastName, phoneNumber, complaint);
    }

    public static void addToQueue(NewComplaintRow log) throws InterruptedException {
        COMPLAINT_LOGS.put(log);
    }

    public int getId() {
        return id;
    }
}