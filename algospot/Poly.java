import java.util.*;

public class Poly {
    static int d[][];
    static final int MOD = 10_000_000;
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();

            d = new int[n+1][n+1];

            int ret = 0;
            for(int i=1; i<=n; i++){
                ret += poly(n, i);
                ret %= MOD;
            }

            System.out.println(ret);
        }

        sc.close();
    }

    static int poly(int n, int first){
        if(n==first) return 1;

        if(d[n][first] != 0) return d[n][first];

        int ret = 0;

        for(int second=1; second <= n-first; second++){
            int add = second + first - 1;

            add *= poly(n-first, second);
            add %= MOD;

            ret += add;
            ret %= MOD;
        }

        d[n][first] = ret;
        return ret;
    }
    
}
