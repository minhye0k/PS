import java.util.*;


public class tiling2 {
    static int d[];
    static final int MOD = 100_000_000_7;
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();
            d = new int[n+1];

            System.out.println(tiling(n));
        }

        sc.close();

    }

    static int tiling(int n){
        if(n==0) return 1;
        if(n==1) return 1;

        if(d[n] != 0) return d[n];

        int ret = tiling(n-1) + tiling(n-2);

        d[n] = ret % MOD;
        return d[n];
    }
    
}
