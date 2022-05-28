package com.example.demo.Book;

public abstract class Book {

    private String name;
    private String language;

    public Book (String name, String language) {
        this.language = language;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
