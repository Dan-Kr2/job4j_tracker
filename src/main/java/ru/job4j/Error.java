package ru.job4j;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error one = new Error();
        Error two = new Error(false, 2, "222");
        Error three = new Error(true, 3, "333");
        one.printInfo();
        two.printInfo();
        three.printInfo();

    }

}
