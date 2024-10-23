import java.util.*;
import java.io.*;

public class jlis {
    static int n, m;
    static int[] A, B;
    static int[][] cache;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();

            A = new int[n];

            m = sc.nextInt();

            B = new int[m];

            cache = new int[n+1][m+1];

            for(int i=0; i<n; i++){
                A[i] = sc.nextInt();
            }

            for(int i=0; i<m; i++){
                B[i] = sc.nextInt();
            }
            int result = jlis(-1,-1);
            System.out.println(result == 2 ? result : result - 2);
        }
    }
    

    static int jlis(int a, int b){
        if(cache[a+1][b+1] != 0) return cache[a+1][b+1];

        long av = a == -1 ? Long.MIN_VALUE : A[a];
        long bv = b == -1 ? Long.MIN_VALUE : B[b];

        long max = Math.max(av, bv);

        int ret = 2;

        for(int i=a+1; i<n; i++){
            if(A[i] > max)
                ret = Math.max(ret, 1 + jlis(i, b));
        }

        for(int i=b+1; i<m; i++){
            if(B[i] > max)
                ret = Math.max(ret, 1 + jlis(a, i));
        }

        cache[a+1][b+1] = ret;
        return ret;
    }
}
