package stack;
import java.util.Scanner;

class ArrayMethod {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public ArrayMethod(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full!");
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        ArrayMethod stack = new ArrayMethod(size);

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
