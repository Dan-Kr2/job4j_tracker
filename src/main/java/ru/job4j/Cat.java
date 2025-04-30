package ru.job4j;

public class Cat {

    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("Котика зовут " + this.name);
        System.out.println("Он кушал " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);

        System.out.println("There is gav's food.");
        Cat gav = new Cat();
        gav.eat("cutlet");
        gav.giveNick("Гав");
        gav.show();
        System.out.println("There is black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Чёрный Кот");
        black.show();
    }
}