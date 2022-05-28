package com.example.demo.Reader;

import com.example.demo.Book.Book;

import java.util.HashSet;

public class ReaderFactory {

    ImportReader importReader;

    public Reader createReader(HashSet<Book> booksList) {
        Reader reader;

        int randomizer = (int) (Math.random()*100);
        if (randomizer > 0 && randomizer < 50) {
            reader = createStudent();
        }
        if (randomizer > 50 && randomizer < 100) {
            reader = createTeacher();
        }
        else reader = createStudent();
        reader.setBooks(booksList);
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
        //int bookAttributeLength = bookAttribute.length;
        //int randomNumber = (int) (Math.random()*10*bookAttributeLength + 1);
        String selected = bookAttribute[(int) (Math.random()*10*bookAttribute.length + 1)];
        return selected;
    }
}
