package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonService {
    private ObjectMapper objectMapper;
    private static JsonService instance;
    private JsonService() {}
    private static JsonService getInstance() {
        if(instance == null)
            instance = new JsonService();
        return instance;
    }
    public static JsonService getInstance(ObjectMapper objectMapper) {
        instance = getInstance();
        instance.objectMapper = objectMapper;

        return instance;
    }

    public String toWriteJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public <T> T toReadJson(String pattern, Class<T> type) throws JsonProcessingException {
        return objectMapper.readValue(pattern,type);
    }
}
