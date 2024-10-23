import java.util.*;

public class Asymtiling {
    static int[] d;
    static final int MOD = 1_000_000_007;
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();
            d = new int[n+1];

            System.out.println(asymtiling(n));
        }

        sc.close();
    }

    static int asymtiling(int n){
        if(n % 2 != 0) 
            return (tiling(n) - tiling(n/2) + MOD) % MOD;

        int ret = (tiling(n) - tiling(n/2) + MOD) % MOD;
        ret = (ret - tiling(n/2 - 1) + MOD)% MOD;

        return ret;
    }

    static int tiling(int n){
        if(n==0) return 1;
        if(n==1) return 1;

        if(d[n] != 0) return d[n];

        int ret = (tiling(n-1) + tiling(n-2)) % MOD;

        d[n] = ret;
        return ret;
    }


    
}
