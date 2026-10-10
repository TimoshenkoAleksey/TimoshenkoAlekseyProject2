package ru.aston.timoshenko.aleksey.project2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonLoader {
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonLoader() {
    }

    public ArrayList<Student> loadStudentsFromJsonFile(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("students.json");
        try {
            return mapper.readValue(inputStream, new TypeReference<ArrayList<Student>>() {
            });
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
