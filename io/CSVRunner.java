package mentoring.levelone.javacoreleveltwo.io;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Формат первого файла items-price.csv:
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * Формат второго файла items-name.csv:
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * Задача:
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля: ID,NAME,PRICE.
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv, где будет лишь одно поле ID.
 */
public class CSVRunner {

    public static void main(String[] args) throws IOException {
        Path itemsPricePath = Path.of("resources", "items-price.csv");
        Path itemsNamePath = Path.of("resources", "items-name.csv");
        Path resultPath = Path.of("resources", "result.csv");
        Path errorPath = Path.of("resources", "errors.csv");
        CSVUtils.write(itemsPricePath, itemsNamePath, resultPath, errorPath);
    }
}