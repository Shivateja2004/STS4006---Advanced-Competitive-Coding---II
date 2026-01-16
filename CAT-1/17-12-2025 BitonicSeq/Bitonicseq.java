import java.util.*;

class Node {
    int data;
    Node prev, next;
    Node(int d) {
        data = d;
        prev = next = null;
    }
}

class Bitonicseq {
    static Node head;

    static void insert(int e) {
        Node n = new Node(e);
        if (head == null) {
            head = n;
            return;
        }
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = n;
        n.prev = t;
    }

    static void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    static void bitonic() {
        if (head == null || head.next == null) return;

        Node left = head;
        Node right = head;
        while (right.next != null) right = right.next;

        Node newHead = null, tail = null;

        while (left != null && right != null && left.prev != right && left != right) {
            Node pick;
            if (left.data <= right.data) {
                pick = left;
                left = left.next;
            } else {
                pick = right;
                right = right.prev;
            }

            pick.prev = pick.next = null;
            if (newHead == null) {
                newHead = tail = pick;
            } else {
                tail.next = pick;
                pick.prev = tail;
                tail = pick;
            }
        }

        // Add remaining one or two nodes
        if (left == right && left != null) {
            tail.next = left;
            left.prev = tail;
        } else if (left != null && left.prev == right) {
            tail.next = left;
            left.prev = tail;
            left.next = right;
            right.prev = left;
        }

        head = newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int x = sc.nextInt();
            if (x == -1) break;
            insert(x);
        }
        bitonic();
        display();
    }
}
