package stack;

import java.util.Scanner;
import java.util.Stack;

public class BuiltinStackClassMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose operation: 1-Push, 2-Pop, 3-Peek, 4-Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty!");
                    } else {
                        System.out.println("Popped value: " + stack.pop());
                    }
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty!");
                    } else {
                        System.out.println("Top value: " + stack.peek());
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}

