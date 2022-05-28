package com.example.demo.Book;
public class RussianFictionBook extends Book{

    String author;
    String book_type;

    public RussianFictionBook(String name, String language, String author, String book_type) {
        super(name, language);
        this.author = author;
        this.book_type = book_type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }
}
