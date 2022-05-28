package com.example.demo;

import com.example.demo.Book.*;
import com.example.demo.Reader.ImportReader;
import com.example.demo.Reader.Reader;
import com.example.demo.Reader.ReaderFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    @FXML
    private TreeView tree ;

    @FXML
    private Button createTree;

    int amountOfBooks = 300;
    int amountOfUsers = 200;
    ArrayList<Reader> readers = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<Book>();

    @FXML
    protected void createTree() throws IOException, InvalidFormatException {

        // создаем список книг
        File book_file = new File("/Users/dazorina/Documents/private/асус не умирай/files_for_laba5/books.xlsx");
        ImportBook importBook = new ImportBook();
        importBook.extract(book_file);
        BookFactory bookFactory = new BookFactory(importBook);
        for (int i = 0; i < amountOfBooks; i++) {
            books.add(bookFactory.createBook());
        }

        // создаем список пользователей
        File user_file = new File("/Users/dazorina/Documents/private/асус не умирай/files_for_laba5/names.xlsx");
        ImportReader importReader = new ImportReader();
        importReader.extract(user_file);
        ReaderFactory readerFactory = new ReaderFactory(importReader);
        for (int i = 0; i < amountOfUsers; i++) {
            readers.add(readerFactory.createReader(books));
        }

        buildTree();
    }

    void buildTree() {

        int amountOfStudent = 0;
        int amountOfTeacher = 0;

        TreeItem<String> rootItem = new TreeItem<>("Пользователи");
        rootItem.setExpanded(true);
        TreeItem<String> studentBranchItem = new TreeItem<>();
        rootItem.getChildren().add(studentBranchItem);
        TreeItem<String> teacherBranchItem = new TreeItem<>();
        rootItem.getChildren().add(teacherBranchItem);

        // заполнение дерева читателями
        for (Reader reader : readers) {
            TreeItem<String> branchItem = new TreeItem<>(reader.getName());
            if (reader.getClass().getName().equals
                    ("com.example.demo.Reader.Student")) {
                studentBranchItem.getChildren().add(branchItem);
                amountOfStudent++;
            }
            else {
                teacherBranchItem.getChildren().add(branchItem);
                amountOfTeacher++;
            }

            reader.getBooks().forEach((obj) -> {
                Book book = (Book) obj;
                TreeItem<String> bookItem = new TreeItem<>(book.getName());
                branchItem.getChildren().add(bookItem);

                //TreeItem<String> leafItemType = new TreeItem<>("type : " + book.getClass().getName());
                //bookItem.getChildren().add(leafItemType);
                TreeItem<String> leafItemLang = new TreeItem<>("lang : " + book.getLanguage());
                bookItem.getChildren().add(leafItemLang);

                if (book instanceof EnglishEducationBook) {
                    EnglishEducationBook book1 = (EnglishEducationBook) book;

                    TreeItem<String> leafItemKind = new TreeItem<>("kind : EnglishEducationBook");
                    bookItem.getChildren().add(leafItemKind);
                    TreeItem<String> leafItemName = new TreeItem<>("author : " + book1.getName());
                    bookItem.getChildren().add(leafItemName);

                    TreeItem<String> leafItemUniversity = new TreeItem<>("university : " + book1.getUniversity());
                    bookItem.getChildren().add(leafItemUniversity);

                    TreeItem<String> leafItemLevel = new TreeItem<>("university : " + book1.getLevel());
                    bookItem.getChildren().add(leafItemLevel);
                }

                if (book instanceof EnglishFictionBook) {
                    TreeItem<String> leafItemKind = new TreeItem<>("kind : EnglishFictionBook");
                    bookItem.getChildren().add(leafItemKind);
                    EnglishFictionBook book2 = (EnglishFictionBook) book;
                    TreeItem<String> leafItemName = new TreeItem<>("author : " + book2.getName());
                    bookItem.getChildren().add(leafItemName);
                }
                if (book instanceof RussianFictionBook) {
                    TreeItem<String> leafItemKind = new TreeItem<>("kind : RussianFictionBook");
                    bookItem.getChildren().add(leafItemKind);
                    RussianFictionBook book3 = (RussianFictionBook) book;
                    TreeItem<String> leafItemAuthor = new TreeItem<>("author : " + book3.getAuthor());
                    bookItem.getChildren().add(leafItemAuthor);
                }

                if (book instanceof RussianEducationBook) {
                    TreeItem<String> leafItemKind = new TreeItem<>("kind : RussianEducationBook");
                    bookItem.getChildren().add(leafItemKind);

                    RussianEducationBook book4 = (RussianEducationBook) book;

                    TreeItem<String> leafItemAuthor = new TreeItem<>("author : " + book4.getAuthor());
                    bookItem.getChildren().add(leafItemAuthor);

                    TreeItem<String> leafItemBookType = new TreeItem<>("book type : " + book4.getBook_type());
                    bookItem.getChildren().add(leafItemBookType);
                }
                else {
                }
            });
    }
        studentBranchItem.setValue("Студенты (" + amountOfStudent + ")");
        teacherBranchItem.setValue("Преподаватели (" + amountOfTeacher + ")");

        tree.setRoot(rootItem);
    }

    void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}