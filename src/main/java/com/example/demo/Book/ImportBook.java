package com.example.demo.Book;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ImportBook {

    private String[] englishEducationBookNames; // лист 1
    private String[] englishEducationBookAuthors; // лист 2
    private String[] englishUniversities; // лист 3
    private String[] englishFictionNames; // лист 4
    private String[] englishFictionAuthors; // лист 5
    private String[] russianEducationBookNames; // лист 6
    private String[] russianFictionNames; // лист 7
    private String[] russianFictionAuthors; // лист 8


    public String[] getRussianEducationBookNames() {
        return russianEducationBookNames;
    }

    public String[] getEnglishEducationBookNames() {
        return englishEducationBookNames;
    }

    public String[] getEnglishUniversities() {
        return englishUniversities;
    }

    public String[] getEnglishEducationBookAuthors() {
        return englishEducationBookAuthors;
    }

    public String[] getRussianFictionNames() {
        return russianFictionNames;
    }

    public String[] getRussianFictionAuthors() {
        return russianFictionAuthors;
    }

    public String[] getEnglishFictionNames() {
        return englishFictionNames;
    }

    public String[] getEnglishFictionAuthors() {
        return englishFictionAuthors;
    }


    public void extract(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        englishEducationBookNames = read(workbook, 0);
        englishEducationBookAuthors = read(workbook, 1);
        englishUniversities = read(workbook, 2);
        englishFictionNames = read(workbook, 3);
        englishFictionAuthors = read(workbook, 4);
        russianEducationBookNames = read(workbook, 5);
        russianFictionNames = read(workbook, 6);
        russianFictionAuthors = read(workbook, 7);
        workbook.close();
    }

    public String[] read(XSSFWorkbook workbook, int num) {
        XSSFSheet sheet = workbook.getSheetAt(num);
        String[] arr = new String[sheet.getLastRowNum() + 1];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0) != null) {
                arr[i] = sheet.getRow(i).getCell(0).getStringCellValue();
            }
        }
        return arr;
    }
}
