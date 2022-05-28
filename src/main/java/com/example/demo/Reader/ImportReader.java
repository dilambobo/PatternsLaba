package com.example.demo.Reader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ImportReader {

    private String[] names;
    private String[] middleNames;
    private String[] secondNames;
    private String[] teacherSecondNames;
    private String[] femaleNames;

    public String[] getTeacherSecondNames() {
        return teacherSecondNames;
    }

    public String[] getNames() {
        return names;
    }

    public String[] getFemaleNames() {
        return femaleNames;
    }

    public String[] getSecondNames() {
        return secondNames;
    }

    public String[] getMiddleNames() {
        return middleNames;
    }

    public void extract(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        names = read(workbook, 0);
        femaleNames = read(workbook, 1);
        secondNames = read(workbook, 2);
        teacherSecondNames = read(workbook, 3);
        middleNames = setMiddleNames();
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

    public String[] setMiddleNames() {
        String[] middleNames = new String[names.length];
        int i = 0;
        for (String name : names) {
            if (name.endsWith("ья")) {
                middleNames[i] = name.substring(0, name.length() - 1) + "ич";
            }else if (name.endsWith("ж") || name.endsWith("ш") || name.endsWith("ч") || name.endsWith("щ") || name.endsWith("ц") || name.endsWith("и") || name.endsWith("э") || name.endsWith("я") || name.endsWith("ю") || name.endsWith("е") || name.endsWith("ё")) {
                middleNames[i] = name + "евич";
            } else if (name.endsWith("н") || name.endsWith("р")|| name.endsWith("м")|| name.endsWith("л")|| name.endsWith("с")|| name.endsWith("б")) {
                middleNames[i] = name + "ович";
            }else if (name.endsWith("а") || name.endsWith("у") || name.endsWith("ы")) {
                middleNames[i] = name.substring(0, name.length() - 1) + "ович";
            } else if (name.endsWith("о")) {
                middleNames[i] = name.substring(0, name.length() - 1) + "вич";
            } else if (name.endsWith("ь")) {
                middleNames[i] = name.substring(0, name.length() - 1) + "евич";
            } else if (name.endsWith("й")) {
                middleNames[i] = name.substring(0, name.length() - 1) + "евич";
            } else {
                middleNames[i] = name + "евич";
            }
            i++;
        }
        return middleNames;
    }

}
