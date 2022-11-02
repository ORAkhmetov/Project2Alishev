package ru.alishev.springcourse.models;

import javax.validation.constraints.*;

/**
 * @author Neil Alishev
 */
public class Person {
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    private String fullName;
    @NotEmpty
    @Min(value = 1900, message = "Год рождения не должен быть меньше 1900")
    //@Pattern(regexp = "[А-Я]\\w+ [А-Я]\\w+ [А-Я]\\w+", message = "Your address should be in this format: Country, City, Postal Code (6 digit)")
    private int yearOfBirth;

    public Person() {}

    public Person(int id, String fullName, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}