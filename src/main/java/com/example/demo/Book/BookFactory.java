package com.example.demo.Book;

public class BookFactory {

    ImportBook importBook;

    public Book createBook() {
        Book book;
        int randomizer = (int) (Math.random()*100);
        if (randomizer > 0 && randomizer < 25) {
            book = createEnglishEducationBook();
        }
        if (randomizer > 25 && randomizer < 50) {
            book = createEnglishFictionBook();
        }
        if (randomizer > 50 && randomizer < 75) {
            book = createRussianEducationBook();
        }
        if (randomizer > 75 && randomizer < 100) {
            book = createRussianFictionBook();
        }
        else book = createRussianEducationBook();
        return book;
    }

    public EnglishEducationBook createEnglishEducationBook() {
        char degree;
        int a = (int) (Math.random()*100);
        if (a > 50) {degree = 'B';} else {degree = 'M';}

        EnglishEducationBook englishEducationBook = new EnglishEducationBook(randomString(importBook.getEnglishEducationBookNames()),
                "ENG",
                randomString(importBook.getEnglishUniversities()),
                degree);
        return englishEducationBook;
    }

    public EnglishFictionBook createEnglishFictionBook() {
        return new EnglishFictionBook(randomString(importBook.getEnglishFictionNames()),
                randomString(importBook.getEnglishFictionAuthors()));
    }

    public RussianEducationBook createRussianEducationBook() {

        String book_type;
        int a = (int) (Math.random()*100);
        if (a > 30) {book_type = "Учебник";} else {book_type = "Задачник";}

        return new RussianEducationBook(randomString(importBook.getRussianEducationBookNames()),
                "RU",
                randomString(importBook.getRussianFictionAuthors()),
                book_type);
    }

    public RussianFictionBook createRussianFictionBook() {

        String book_type;
        int a = (int) (Math.random()*100);
        if (a > 30) {book_type = "Роман";} else {book_type = "Повесть";}

        return new RussianFictionBook(randomString(importBook.getRussianFictionNames()),
                "RU",
                randomString(importBook.getRussianFictionAuthors()),
                book_type);
    }


    // метод для выбора случайного значения из массива данных о книге
    private String randomString(String[] bookAttribute) {
        //int bookAttributeLength = bookAttribute.length;
        //int randomNumber = (int) (Math.random()*10*bookAttributeLength + 1);
        String selected = bookAttribute[(int) (Math.random()*10*bookAttribute.length + 1)];
        return selected;
    }
}
