package stack;

import java.util.ArrayList;
import java.util.Scanner;

public class FIFO_queue_using_ArrayList {
    private ArrayList<Integer> queue;

    public FIFO_queue_using_ArrayList() {
        queue = new ArrayList<>();
    }

    public void enqueue(int value) {
        queue.add(value);
    }

    public int dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.remove(0);
    }

    public static void main(String[] args) {
        FIFO_queue_using_ArrayList queue = new FIFO_queue_using_ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("ArrayList Queue Implementation");
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
