package services.logger;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsoleLogStrategy implements LogStrategy {
    @Override
    public void log(String message) {
        System.out.println(LocalDate.now() + ", " + LocalTime.now() + ": " + message);
    }
}