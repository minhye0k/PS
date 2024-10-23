import java.util.*;
import java.io.*;

public class lis {

    static int N;
    static int[] d;
    static int[] seq;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            N = sc.nextInt();
            seq = new int[N];
            d = new int[N+1];
            Arrays.fill(d, -1);

            for(int i=0; i<N; i++){
                seq[i] = sc.nextInt();
            }

            int ret = lis2(-1) - 1;
            // for(int i=0; i<N; i++){
            //     ret = Math.max(ret, lis(i));
            // }
            System.out.println(ret);
        }

        sc.close();
    }

    static int lis(int start){
        if(d[start] != -1){
            return d[start];
        }

        int ret = 1;

        for(int i=start+1; i<N; i++){
            if(seq[start] < seq[i]) ret = Math.max(ret, 1 + lis(i));
        }

        d[start] = ret;
        return ret;
    }

    static int lis2(int start){
        if(d[start+1] != -1){
            return d[start+1];
        }

        int ret = 1;

        for(int i=start+1; i<N; i++){
            if(start == -1 || seq[start] < seq[i]) ret = Math.max(ret, 1 + lis(i));
        }

        d[start+1] = ret;
        return ret;
    }
    
}
