package com.spencer.springsecurity.entities;

public class Student {
    private String name;
    private String rollno;
    private int average;

    public Student(int average, String rollno, String name) {
        this.average = average;
        this.rollno = rollno;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno='" + rollno + '\'' +
                ", average=" + average +
                '}';
    }
}
