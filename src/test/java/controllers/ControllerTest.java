package controllers;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {
    private URL url;
    private String requestedMethod;
    private String expectedJson;

    public ControllerTest(URL url, String requestedMethod, String expectedJson) {
        this.url = url;
        this.requestedMethod = requestedMethod;
        this.expectedJson = expectedJson;
    }

    public void toTest() throws Exception {
        // Создаём реальный HTTP запрос с параметрами
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestedMethod);

        // Получаем ответ
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        // Чтение данных до конца потока
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();

        assertEquals(expectedJson, content.toString());
    }
}
