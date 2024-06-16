package stack;

import java.util.ArrayList;
import java.util.Scanner;

public class Steque {
    private ArrayList<Integer> list;

    public Steque() {
        list = new ArrayList<>();
    }

    public void addFront(int element) {
        list.add(0, element);
    }

    public void addRear(int element) {
        list.add(element);
    }

    public int removeFront() {
        if (list.isEmpty()) {
            System.out.println("Steque is empty. Cannot remove element.");
            return -1;
        }
        return list.remove(0);
    }

    public void display() {
        System.out.println("Steque: " + list);
    }

    public static void main(String[] args) {
        Steque steque = new Steque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add to front");
            System.out.println("2. Add to rear");
            System.out.println("3. Remove from front");
            System.out.println("4. Display Steque");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add to front: ");
                    steque.addFront(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter element to add to rear: ");
                    steque.addRear(scanner.nextInt());
                    break;
                case 3:
                    steque.removeFront();
                    break;
                case 4:
                    steque.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}