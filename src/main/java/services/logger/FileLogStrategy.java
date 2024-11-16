package services.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileLogStrategy implements LogStrategy {
    @Override
    public void log(String message) {
        String fileName = "log_" + LocalDate.now() + "_" + LocalTime.now() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(LocalDate.now() + ", " + LocalTime.now() + ": " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}