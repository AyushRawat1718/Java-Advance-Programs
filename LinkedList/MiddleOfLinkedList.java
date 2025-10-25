// Given the head of a singly linked list, return a pointer pointing to the middle of the linked list.
// If there are an odd number of elements, return the middle element.
// If there are even number of elements, return the one which is farther from the head node.
// Example: 1 -> 2 -> 3 -> 4 -> NULL → middle = 3

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleOfLinkedList {

    // Create a new Linked List when head is null
    static Node startLL(int data) {
        return new Node(data);
    }

    // Traverse the Linked List
    static void traversal(Node head) {
        Node current = head;
        System.out.print("Your Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("Current Head: " + head.data);
    }

    // Insert element at the end of Linked List
    static void insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Convert an ArrayList to Linked List
    static Node arrayToLL(List<Integer> arr) {
        if (arr.size() == 0) return null;
        Node head = new Node(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            insertAtEnd(head, arr.get(i));
        }
        return head;
    }

    // Approach 1: Using Length
    static int getLength(Node head) {
        int counter = 0;
        Node current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    static Node getMiddlePointer1(Node head) {
        int length = getLength(head);
        if (length == 0) return null;

        int requiredPosition = (length / 2) + 1; // Works for both even & odd cases
        int position = 1;
        Node current = head;

        while (position != requiredPosition) {
            position++;
            current = current.next;
        }
        return current;
    }

    // Approach 2: Slow & Fast Pointer (Optimized)
    // For even length, returns the second middle (farther from head)
    static Node getMiddlePointer2(Node head) {
        if (head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    // Main method
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Node head = arrayToLL(arr);
        traversal(head);

        Node middle = getMiddlePointer2(head);
        System.out.println("The middle element of this L.L. is " + middle.data + " & its pointer is " + middle);
    }
}
