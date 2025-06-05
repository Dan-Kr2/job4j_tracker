package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ost = 11;
        int win = 0;
        int take1;
        int take2;

        while (ost > 0) {
            System.out.println("Первый игрок, введите число спичек, которые хотите взять (можно взять от 1 до 3 спичек)");
            take1 = scanner.nextInt();

            if (take1 < 1 || take1 > 3) {
                System.out.println("Нет, вы можете взять только от 1 до 3 спичек!");
                while (true) {
                    System.out.println("Возьмите 1 спичку, 2 спички или 3 спички!");
                    take1 = scanner.nextInt();
                    if (take1 == 1 || take1 == 2 || take1 == 3) {
                        break;
                    }
                }
            }
            ost = ost - take1;
            System.out.println("На столе осталось " + ost + " спичек");
            win = 1;
            if (ost < 0) {
                break;
            }

            System.out.println("Второй игрок, введите число спичек, которые хотите взять (можно взять от 1 до 3 спичек)");
            take2 = scanner.nextInt();
            if (take2 < 1 || take2 > 3) {
                System.out.println("Нет, вы можете взять только от 1 до 3 спичек!");
                while (true) {
                    System.out.println("Возьмите 1 спичку, 2 спички или 3 спички!");
                    take2 = scanner.nextInt();
                    if (take2 == 1 || take2 == 2 || take2 == 3) {
                        break;
                    }
                }
            }
                    ost = ost - take2;
                    System.out.println("На столе осталось " + ost + " спичек");
                    win = 2;
                    if (ost < 0) {
                        break;
                    }

                }
                if (win == 1) {
                    System.out.println("Выиграл первый игрок");
                } else {
                    System.out.println("Выиграл второй игрок");
                }
            }
        }
