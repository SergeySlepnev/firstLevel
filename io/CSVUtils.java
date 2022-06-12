package mentoring.levelone.javacoreleveltwo.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.util.stream.Collectors.toMap;

public class CSVUtils {

    private final static String COMMA_DELIMITER = ",";

    public static void write(Path itemsPricePath,
                             Path itemsNamePath,
                             Path resultPath,
                             Path errorPath) throws IOException {
        Map<String, String> itemsPriceMap = getMapOfString(itemsPricePath);
        Map<String, String> itemsNameMap = getMapOfString(itemsNamePath);
        Map<String, String> mergedMap = getMergedByKeyMap(itemsPriceMap, itemsNameMap);
        try (BufferedWriter resultWriter = Files.newBufferedWriter(resultPath, CREATE, TRUNCATE_EXISTING);
             BufferedWriter errorWriter = Files.newBufferedWriter(errorPath, CREATE, TRUNCATE_EXISTING)) {
            for (Map.Entry<String, String> record : mergedMap.entrySet()) {
                if (record.getValue().isEmpty()) {
                    errorWriter.write(record.getKey());
                    errorWriter.newLine();
                } else {
                    resultWriter.write(record.getKey() + "," + record.getValue());
                    resultWriter.newLine();
                }
            }
        }
    }

    private static Map<String, String> getMapOfString(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        return lines.stream()
                .map(s -> s.split(COMMA_DELIMITER))
                .collect(toMap(
                        s -> s[0],
                        s -> s.length > 1 ? s[1] : "",
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
    }

    private static Map<String, String> getMergedByKeyMap(Map<String, String> itemsPriceMap,
                                                         Map<String, String> itemsNameMap) {
        return Stream.of(itemsPriceMap, itemsNameMap)
                .flatMap(map -> map.entrySet().stream())
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v2 + "," + v1,
                        LinkedHashMap::new
                ));
    }
}