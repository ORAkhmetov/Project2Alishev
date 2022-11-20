package ru.alishev.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int book_id;
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min=2, max=100, message = "Название книги должно быть от 2 до 100 символов длиной")
    private String title;
    @NotEmpty(message = "Автор не должен быть пустым")
    @Size(min=2, max=100, message = "Имя автора должно быть от 2 до 100 символов длиной")
    private String author;
    @Min(value = 868, message = "Год издания не должен быть меньше 868")
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
