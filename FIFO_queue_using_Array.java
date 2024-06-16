package stack;

import java.util.Scanner;

public class FIFO_queue_using_Array {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public FIFO_queue_using_Array(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        FIFO_queue_using_Array queue = new FIFO_queue_using_Array(capacity);
        System.out.println("Array Queue Implementation");
        while (true) {
            System.out.println("1. Enqueue  2. Dequeue  3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    try {
                        queue.enqueue(value);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int dequeuedValue = queue.dequeue();
                        System.out.println("Dequeued value: " + dequeuedValue);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

