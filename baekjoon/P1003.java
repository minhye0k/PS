import java.util.*;

public class P1003 {

    static int d0[] = new int[41];
    static int d1[] = new int[41];

    static int fibonacci0(int n){
        if(d0[n] != 0) return d0[n];

        if(n==0){
            return 1;
        }else if(n==1){
            return 0;
        }else{
            return d0[n] = fibonacci0(n-1) + fibonacci0(n-2);
        }
    }

    static int fibonacci1(int n){
        if(d1[n] != 0) return d1[n];

        if(n==1){
            return 1;
        }else if(n==0){
            return 0;
        }else{
            return d1[n] = fibonacci1(n-1) + fibonacci1(n-2);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            System.out.println(fibonacci0(n) + " " + fibonacci1(n));
        }

        sc.close();
    }
}
