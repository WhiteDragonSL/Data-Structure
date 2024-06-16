package stack;

import java.util.LinkedList;
import java.util.Scanner;

public class FIFO_queue_using_LinkedList {
    private LinkedList<Integer> queue;

    public FIFO_queue_using_LinkedList() {
        queue = new LinkedList<>();
    }

    public void enqueue(int value) {
        queue.add(value);
    }

    public int dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public static void main(String[] args) {
        FIFO_queue_using_LinkedList queue = new FIFO_queue_using_LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("LinkedList Queue Implementation");
        while (true) {
            System.out.println("1. Enqueue  2. Dequeue  3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
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
