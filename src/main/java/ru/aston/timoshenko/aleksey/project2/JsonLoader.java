package ru.aston.timoshenko.aleksey.project2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonLoader() {
    }

    public List<Student> loadStudentsFromJsonFile(String fileName) {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            if(inputStream == null) {
                throw new ResourceNotFoundException("Resource not found: " + fileName);
            }
            return mapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (IOException | ResourceNotFoundException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
