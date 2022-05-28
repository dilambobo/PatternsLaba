package com.example.demo.Book;

public class EnglishEducationBook extends Book{

    private String university;
    private char level; // "M" = Magistracy, "B" = bachelor

    public EnglishEducationBook(String name, String language, String university, char level) {
        super(name, language);
        this.university = university;
        this.level = level;
    }
}
