package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Deque_Using_2_FIFO_Queues<T> {
    private Queue<T> frontQueue;
    private Queue<T> backQueue;

    public Deque_Using_2_FIFO_Queues() {
        this.frontQueue = new LinkedList<>();
        this.backQueue = new LinkedList<>();
    }

    // Add to the front
    public void addFirst(T item) {
        frontQueue.offer(item);
        balanceQueues();
    }

    // Add to the back
    public void addLast(T item) {
        backQueue.offer(item);
        balanceQueues();
    }

    // Remove from the front
    public T removeFirst() {
        if (frontQueue.isEmpty() && backQueue.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        if (frontQueue.isEmpty()) {
            balanceQueues();
        }
        return frontQueue.poll();
    }

    // Remove from the back
    public T removeLast() {
        if (frontQueue.isEmpty() && backQueue.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        if (backQueue.isEmpty()) {
            balanceQueues();
        }
        return backQueue.poll();
    }

    // Get the first element
    public T peekFirst() {
        if (frontQueue.isEmpty() && backQueue.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        if (frontQueue.isEmpty()) {
            balanceQueues();
        }
        return frontQueue.peek();
    }

    // Get the last element
    public T peekLast() {
        if (frontQueue.isEmpty() && backQueue.isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        if (backQueue.isEmpty()) {
            balanceQueues();
        }
        return backQueue.peek();
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return frontQueue.isEmpty() && backQueue.isEmpty();
    }

    // Balance the queues if needed
    private void balanceQueues() {
        int totalSize = frontQueue.size() + backQueue.size();
        int halfSize = totalSize / 2;

        if (frontQueue.size() > halfSize) {
            while (frontQueue.size() > halfSize) {
                backQueue.offer(frontQueue.poll());
            }
        } else if (backQueue.size() > halfSize) {
            while (backQueue.size() > halfSize) {
                frontQueue.offer(backQueue.poll());
            }
        }
    }

    public static void main(String[] args) {
        Deque_Using_2_FIFO_Queues<Integer> deque = new Deque_Using_2_FIFO_Queues<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deque Operations:");
        System.out.println("1: Add First");
        System.out.println("2: Add Last");
        System.out.println("3: Remove First");
        System.out.println("4: Remove Last");
        System.out.println("5: Peek First");
        System.out.println("6: Peek Last");
        System.out.println("7: Check if Empty");
        System.out.println("8: Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add to the front: ");
                    int elementToAddFirst = scanner.nextInt();
                    deque.addFirst(elementToAddFirst);
                    System.out.println(elementToAddFirst + " added to the front.");
                    break;
                case 2:
                    System.out.print("Enter the element to add to the back: ");
                    int elementToAddLast = scanner.nextInt();
                    deque.addLast(elementToAddLast);
                    System.out.println(elementToAddLast + " added to the back.");
                    break;
                case 3:
                    try {
                        int removedFirst = deque.removeFirst();
                        System.out.println(removedFirst + " removed from the front.");
                    } catch (IllegalStateException e) {
                        System.out.println("Deque is empty. Cannot remove from the front.");
                    }
                    break;
                case 4:
                    try {
                        int removedLast = deque.removeLast();
                        System.out.println(removedLast + " removed from the back.");
                    } catch (IllegalStateException e) {
                        System.out.println("Deque is empty. Cannot remove from the back.");
                    }
                    break;
                case 5:
                    try {
                        int peekFirst = deque.peekFirst();
                        System.out.println("First element is: " + peekFirst);
                    } catch (IllegalStateException e) {
                        System.out.println("Deque is empty. No front element.");
                    }
                    break;
                case 6:
                    try {
                        int peekLast = deque.peekLast();
                        System.out.println("Last element is: " + peekLast);
                    } catch (IllegalStateException e) {
                        System.out.println("Deque is empty. No last element.");
                    }
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty.");
                    } else {
                        System.out.println("Deque is not empty.");
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
