package ru.alishev.springcourse.models;


public class Book {


    private int id;
    private String name;

    private String author;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book(String name, String author, int age) {
        this.name = name;
        this.author = author;
        this.age = age;
    }

    public Book(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int ageOfBook) {
        this.age = ageOfBook;
    }


}
