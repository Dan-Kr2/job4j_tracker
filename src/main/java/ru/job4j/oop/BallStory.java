package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Fox fox = new Fox();
        hare.tryEat(kolobok);
        wolf.tryEat(kolobok);
        fox.tryEat(kolobok);
    }
}