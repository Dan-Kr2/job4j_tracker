package ru.job4j.pojo;

public class Book {
    private String title;
    private int thickness;

    public Book(String title, int thickness) {
        this.title = title;
        this.thickness = thickness;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
}
