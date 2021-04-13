package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== List of Items ====");
                Item[] list = tracker.findAll();
                for (Item n: list) {
                    System.out.println(n.toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit a selected Item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    Item newItem = new Item(item.getName());
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Item saved");
                    } else {
                        System.out.println("Item saving failed");
                    }
                }
            } else if (select == 3) {
                System.out.println("=== Delete selected Item ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Item deletion failed");
                }
            } else if (select == 4) {
                System.out.println("=== Select Item by id ====");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find Items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] list = tracker.findByName(name);
                if (list.length > 0) {
                    for (Item n: list) {
                        System.out.println(n.getName());
                    }
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}