package ru.aston.timoshenko.aleksey.project2;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;
    private int pages;


    public Book() {
    }

    public Book(String title, String author, int year, int pages) {
        this.title = validateTitle(title);
        this.author = validateAuthor(author);
        this.year = validateYear(year);
        this.pages = validatePages(pages);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = validateTitle(title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = validateAuthor(author);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = validateYear(year);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = validatePages(pages);
    }

    private static String validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Название книги не может быть пустым или состоять только из пробелов.");
        }
        return title.strip();
    }

    private static String validateAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException(
                    "Имя автора книги не может быть пустым или состоять только из пробелов.");
        }
        return author.strip();
    }

    private static int validateYear(int year) {
        if (year < 1440 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Книга не могла быть напечатана, раньше начала эпохи книгопечатания " +
                    "и позже текущего года.");
        }
        return year;
    }

    private static int validatePages(int pages) {
        if (pages < 1) {
            throw new IllegalArgumentException("В книге не может быть ноль и менее страниц.");
        }
        return pages;
    }

    @Override
    public int compareTo(Book o) {
        return this.pages - o.pages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                '}';
    }
}
