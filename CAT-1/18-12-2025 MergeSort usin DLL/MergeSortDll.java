import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

public class MergeSortDll {
    static Node head;

    static void insert(int e){
        Node newNode = new Node(e);
        if(head == null) head = newNode;
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }

    public static Node merge(Node h1,Node h2){
        Node dummy = new Node(-1);
        Node curr = dummy;
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        while(h1!=null && h2 !=null){
            if(h1.data<h2.data){//change > for greater than for decreasing order in result;
                curr.next = h1;
                h1.prev = curr;
                h1 = h1.next;
            }else{
                curr.next = h2;
                h2.prev=curr;
                h2=h2.next;
            }

            curr= curr.next;
        }

        if(h1!=null){
            curr.next = h1;
            h1.prev=curr;
        }
        if(h2!=null){
            curr.next=h2;
            h2.prev=curr;
        }

        dummy = dummy.next;
        dummy.prev = null;
        return dummy;
    }


    public static Node split(Node head){
        Node slow=head,fast=head;
        while(fast.next !=null &&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        temp.prev = null;
        slow.next = null;
        return temp;
    }

    public static Node sort(Node head){
        if(head == null || head.next == null) return head;
        Node h2 = split(head);
        Node h1=sort(head);
        h2=sort(h2);
        return merge(h1,h2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ele;
        while(true){
            ele = sc.nextInt();
            if(ele == -1){
                break;
            }
            insert(ele);
        }
        Node h = sort(head);
        display(h);
    }
}
