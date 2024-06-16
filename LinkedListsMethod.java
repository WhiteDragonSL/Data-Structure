package stack;

import java.util.Scanner;

class LinkedListStack {
    private class Node {
        int data;
        Node next;
    }

    private Node top;

    public LinkedListStack() {
        top = null;
    }

    public void push(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return top.data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListStack stack = new LinkedListStack();

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
                    System.out.println("Popped value: " + stack.pop());
                    break;
                case 3:
                    System.out.println("Top value: " + stack.peek());
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
