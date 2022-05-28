package com.example.demo.Reader;

public class Teacher extends Reader{

    private String middle_name;

    public Teacher(String first_name, String second_name, String middle_name) {
        super(first_name, second_name);
        this.middle_name = middle_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    @Override
    public String getName() {
        return getFirst_name() + " " + middle_name + " " + getSecond_name();
    }
}
