import java.util.*;

public class MinimumStack{
    static Stack<Integer> st = new Stack<Integer>();
    static Stack<Integer> mst = new Stack<Integer>();

    static void getmin(){
        if(mst.isEmpty()){
            System.out.println("Stack is Empty");
        }else{
            System.out.println(mst.peek());
        }
    }

    static void peek(){
        if(st.isEmpty()){
            System.out.println("Stack is Empty");
        }else{
            System.out.println(st.peek());
        }
    }


    static void pop(){
        int t = st.pop();
        if(t == mst.peek()) mst.pop();
    }


    static void push(int x){
        if(st.isEmpty()){
            st.push(x);
            mst.push(x);
        }else{
            st.push(x);
            if(x <= mst.peek()) mst.push(x);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n;i++){
            int l = sc.nextInt();
            push(l);
        }

        System.out.println("Min Element: ");
        getmin();
        pop();
        System.out.println("Min Element: ");
        getmin();
    }
}
