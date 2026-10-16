package ru.aston.timoshenko.aleksey.project2;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private List<Book> books;

    public Student() {
    }

    public Student(String name, int age, List<Book> books) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.books = validateBooks(books);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = validateAge(age);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = validateBooks(books);
    }

    private static String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым.");
        }
        return name.strip();
    }

    private static int validateAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Возраст студента не может быть равен нулю или быть меньше нуля.");
        }
        return age;
    }

    private static List<Book> validateBooks(List<Book> books) {
        if (books == null || books.size() < 5) {
            throw new IllegalArgumentException("У каждого студента должно быть не менее пяти книг.");
        }
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(books, student.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, books);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }
}
