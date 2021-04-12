package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Букварь", 100);
        Book book2 = new Book("Практика программирования", 350);
        Book book3 = new Book("Айвенго", 700);
        Book book4 = new Book("Clean code", 450);
        Book[] lib = new Book[4];
        lib[0] = book1;
        lib[1] = book2;
        lib[2] = book3;
        lib[3] = book4;
        for (int i = 0; i < lib.length; i++) {
            System.out.println(lib[i].getName() + ", " + lib[i].getPages() + " страниц");
        }
        System.out.println("--------------------------------------");
        Book temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        for (int i = 0; i < lib.length; i++) {
            String name = lib[i].getName();
            if ("Clean code".equals(name)) {
                System.out.println(lib[i].getName() + ", " + lib[i].getPages() + " страниц");
            }
        }
    }
}
