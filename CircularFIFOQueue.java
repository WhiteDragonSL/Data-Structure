package stack;

import java.util.Scanner;

public class CircularFIFOQueue {
    private int[] queue;
    private int front, rear, size;
    private int capacity;

    // Constructor to initialize the queue
    public CircularFIFOQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = item;
        size++;
        System.out.println(item + " enqueued to queue");
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue");
            return Integer.MIN_VALUE;
        }
        int item = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println(item + " dequeued from queue");
        return item;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to display the elements of the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        
        CircularFIFOQueue queue = new CircularFIFOQueue(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
