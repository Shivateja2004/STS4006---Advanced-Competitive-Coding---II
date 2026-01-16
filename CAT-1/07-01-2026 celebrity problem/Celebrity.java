import java.util.*;

class Celebrity{
    static boolean knows(int a,int b,int r[][]){
        return r[a][b] == 1;
    }

    static int findcelebrity(int n,int m[][]){
        Stack<Integer> st = new Stack<>();
        int c;

        for(int i = 0;i < n;i++){
            st.push(i);
        }

        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();
            if(knows(a,b,m)) st.push(b);
            else st.push(a);
        }

        c = st.pop();
        for(int i = 0;i < n;i++){
            if((i!= c) && knows(c,i,m) || !knows(i,c,m)) return -1;
        }
        return c;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m[][] = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                m[i][j] = sc.nextInt();
            }
        }
        int res = findcelebrity(n,m);
        if(res == -1){
            System.out.println("No Celebrity");
        }else{
            System.out.println("Celebrity found at index : "+res);
        }
    }
}
