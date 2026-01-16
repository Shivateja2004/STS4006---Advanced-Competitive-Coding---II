public class DLL {

    // Doubly Linked List Node
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    static Node head = null;

    // Insert at beginning
    static void insertAtBeg(int e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    static void insertAtEnd(int e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Display forward
    static void display() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            count++;
        }
        System.out.println();
        System.out.println(count);
    }

    

    public static void main(String[] args) {
        insertAtEnd(10);
        insertAtEnd(43);
        insertAtBeg(34);
        insertAtBeg(45);
        insertAtEnd(4);

        display();         // Forward traversal
        
    }
}
