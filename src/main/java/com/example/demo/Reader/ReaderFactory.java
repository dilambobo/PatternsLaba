package com.example.demo.Reader;

import com.example.demo.Book.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class ReaderFactory {

    ImportReader importReader;

    public ReaderFactory (ImportReader importReader) {
        this.importReader = importReader;
    }

    public Reader createReader(ArrayList<Book> booksList) {
        Reader reader;

        int randomizer = (int) (Math.random()*100);
        if (randomizer > 0 && randomizer < 50) {
            reader = createStudent();
        }
        if (randomizer > 50 && randomizer < 100) {
            reader = createTeacher();
        }
        else reader = createStudent();
        reader.setBooks(genBooks(booksList));
        return reader;
    }

    public Student createStudent() {
        return new Student(randomString(importReader.getNames()),randomString(importReader.getSecondNames()));
    }

    public Teacher createTeacher() {
        return new Teacher(randomString(importReader.getNames()),
                randomString(importReader.getSecondNames()),
                randomString(importReader.getMiddleNames()));
    }

    // метод для выбора случайного значения из массива данных о книге
    private String randomString(String[] bookAttribute) {
        String selected = bookAttribute[(int) (bookAttribute.length * Math.random())];
        return selected;
    }

    public ArrayList genBooks(ArrayList<Book> booksList) {
        int num = ThreadLocalRandom.current().nextInt(3, 11);
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            books.add(booksList.get(ThreadLocalRandom.current().nextInt(0, booksList.size())));
        }
        return books;
    }
}
