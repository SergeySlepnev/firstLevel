package mentoring.levelone.javacoreleveltwo.regex.service;

import mentoring.levelone.javacoreleveltwo.regex.model.logResources.LogType;
import mentoring.levelone.javacoreleveltwo.regex.util.IOConst;

import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class SupportService extends Thread {

    public SupportService() {
    }

    @Override
    public void run() {

        try {
            writeHeaders();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new IncomingCall().start();
        CallCenterOperator.CALL_CENTER_OPERATORS.forEach(operator -> new Thread(operator).start());
        SupportDispatcher.renewLastLogs();
        SupportDispatcher.SUPPORT_DISPATCHERS.forEach(dispatcher -> new Thread(dispatcher).start());
    }

    private void writeHeaders() throws IOException {
        Files.writeString(IOConst.newComplaintPath, LogType.NEW_COMPLAINTS_LOG.getHeaders() + '\n', CREATE, TRUNCATE_EXISTING);
        Files.writeString(IOConst.handledComplaintPath, LogType.HANDLED_COMPLAINTS_LOG.getHeaders() + '\n', CREATE, TRUNCATE_EXISTING);
    }
}