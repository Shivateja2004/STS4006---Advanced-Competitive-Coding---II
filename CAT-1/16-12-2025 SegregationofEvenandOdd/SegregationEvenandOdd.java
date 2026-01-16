import java.util.*;

class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next=null;
    }
}

class SegregationEvenandOdd{
    static Node head;
    static void insertatend(int e){
        Node newnode = new Node(e);
        if(head == null){
            head = newnode;
            return;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }

    static void segregate(){
        Node even_start = null;
        Node even_end = null;
        Node odd_start = null;
        Node odd_end = null;
        Node temp = head;
        while(temp!=null){
            if(temp.data % 2 == 0){
                if(even_start == null){
                    even_start = even_end = temp;
                }else{
                    even_end.next = temp;
                    even_end = temp;
                }
            }else{
                if(odd_start == null) odd_start = odd_end = temp;
                else{
                    odd_end.next = temp;
                    odd_end = temp;
                }
            }
            temp = temp.next;
        }
        
        if(even_start == null || odd_start == null){
            return;
        }else{
            even_end.next = odd_start;
            odd_end.next = null;
            head = even_start;

            /*for odd case
            odd_end.next = even_start;
            even_end.next = null;
            head = odd_start;
            */
        }
        
    }

    static void display(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ele;
        while(true){
            ele = sc.nextInt();
            if(ele == -1){
                break;
            }else{
                insertatend(ele);
            }
        }
        segregate();
        display();
    }
}
