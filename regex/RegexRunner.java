package mentoring.levelone.javacoreleveltwo.regex;

import mentoring.levelone.javacoreleveltwo.regex.service.SupportService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class RegexRunner {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        new SupportService().start();
    }
}