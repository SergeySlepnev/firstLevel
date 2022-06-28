package mentoring.levelone.javacoreleveltwo.regex.service;

import mentoring.levelone.javacoreleveltwo.regex.model.logResources.NewComplaintRow;
import mentoring.levelone.javacoreleveltwo.regex.util.FormatUtils;
import mentoring.levelone.javacoreleveltwo.regex.util.IOConst;

import java.nio.file.Files;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class ComplaintLogJob implements Callable<BlockingQueue<NewComplaintRow>> {

    private static final long HEADER_ROW = 1L;

    //  не нашёл способ, чтобы сразу из стрима вернуть BlockingQueue. Можно это сделать как-то?
    @Override
    public BlockingQueue<NewComplaintRow> call() throws Exception {
        Stream<String> lines = Files.lines(IOConst.newComplaintPath);
        var list = lines.skip(HEADER_ROW)
                .map(row -> row.split(FormatUtils.COMMA))
                .map(NewComplaintRow::new)
                .toList();
        NewComplaintRow.COMPLAINT_LOGS.removeAll(list);
        return new ArrayBlockingQueue<>(list.size(), true, list);
    }
}