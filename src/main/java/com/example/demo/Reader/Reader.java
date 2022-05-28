package com.example.demo.Reader;

import com.example.demo.Book.Book;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Reader {

    private String first_name;
    private String second_name;
    ArrayList<Book> books = new ArrayList<>();

    public Reader (String first_name, String second_name) {
        this.first_name = first_name;
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getName() {
        return first_name + " " + second_name;
    }

}
