class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next=null;
    }
}

class LoopDetection{
    static Node head;

    static void insert(int ele){
        Node newNode = new Node(ele);
        if(head == null){
            head = newNode;
            return;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    static void create(int pos){
        if(pos < 0) return;
        else{
            int ind = 0;
            Node loopnode = null;
            Node temp = head;
            while(temp.next != null){
                if(ind == pos){
                    loopnode = temp;
                }
                temp = temp.next;
                ind++;
            }
            if(ind+1==pos && temp.next==null)
            { temp.next = loopnode;
            }
            else
            {
                temp.next = loopnode;
            }
        }
    }

    static boolean detect(){
        Node slow = head,fast=head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast)return true;
        }
        return false;
    }

    static void display(){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
            count++;
        }
        System.out.println();
        System.out.println(count);
    }

    public static void main(String[] args){
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        create(4);
        if(detect()){
            System.out.println("Loop Detected");
        }else{
            System.out.println("No loop Detected");
        }
    }
}
