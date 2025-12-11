class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}

class SLL{
    static Node head;
    static void insertatbeg(int e){
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
            return;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    static void insertatend(int e){
        Node newNode = new Node(e);
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
        insertatend(10);
        insertatend(43);
        insertatbeg(34);
        insertatbeg(45);
        insertatend(4);
        display();
    }
}
