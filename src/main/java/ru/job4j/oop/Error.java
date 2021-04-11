package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
        this.active = false;
        this.status = 0;
        this.message = "";
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активен: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error err0 = new Error();
        Error err1 = new Error(true, 1, "Ошибка 1");
        Error err2 = new Error(true, 2, "Ошибка 2");
        Error err3 = new Error(true, 3, "Ошибка 3");
        err0.printInfo();
        err1.printInfo();
        err2.printInfo();
        err3.printInfo();
    }
}
