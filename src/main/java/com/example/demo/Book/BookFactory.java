package com.example.demo.Book;

public class BookFactory {

    ImportBook importBook;

    public BookFactory(ImportBook importBook) {
        this.importBook = importBook;
    };

    public Book createBook() {
        Book book;
        int randomizer = (int) (Math.floor(Math.random()*4)) ;

        switch (randomizer){
            case (0): {
                book = createEnglishEducationBook();
                break;
            }
            case (1): {
                book = createEnglishEducationBook();
                break;
            }
            case (2): {
                book = createRussianEducationBook();
                break;
            }
            case (3): {
                book = createRussianFictionBook();
                break;
            }
            default: book = createEnglishEducationBook();
        }
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
        String selected = bookAttribute[(int) (bookAttribute.length * Math.random())];
        return selected;
    }
}
