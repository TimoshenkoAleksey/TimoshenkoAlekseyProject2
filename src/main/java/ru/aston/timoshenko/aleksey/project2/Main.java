package ru.aston.timoshenko.aleksey.project2;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        JsonLoader loader = new JsonLoader();
        List<Student> students = loader.loadStudentsFromJsonFile("students.json");
        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findAny()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No books found"));

    }
}
