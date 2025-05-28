package ru.job4j.pojo;

import java.text.AttributedCharacterIterator;

public class Library {
    public static void main(String[] args) {
        Book randomBook = new Book("Random Book", 500);
        Book randomBook2 = new Book("Random Book 2", 450);
        Book smallBook = new Book("Random small Book", 5);
        Book taskBook = new Book("Clean code", 464);
        Book[] myLibrary = new Book[4];
        myLibrary[0] = randomBook;
        myLibrary[1] = randomBook2;
        myLibrary[2] = smallBook;
        myLibrary[3] = taskBook;
        for (int i = 0; i < myLibrary.length; i++) {
            Book selectedBook = myLibrary[i];
            System.out.println(selectedBook.getTitle() + " has " + selectedBook.getThickness() + " pages.");
        }
        System.out.println(" ");
        Book bukkit = new Book("some title", 22);
        bukkit = randomBook;
        randomBook = taskBook;
        taskBook = bukkit;
        for (int i = 0; i < myLibrary.length; i++) {
            Book selectedBook = myLibrary[i];
            System.out.println(selectedBook.getTitle() + " has " + selectedBook.getThickness() + " pages.");
        }
        System.out.println(" ");
        for (int i = 0; i < myLibrary.length; i++) {
            Book seekBook = myLibrary[i];
        if (seekBook.getTitle() == "Clean code") {
            System.out.println(seekBook.getTitle());
        }

        }
    }
}
