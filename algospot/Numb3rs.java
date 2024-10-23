import java.util.*;

public class Numb3rs {
    static int n, d, p, q;
    static double[][] cache;
    static int[][] connected;
    static int[] deg;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();
            d = sc.nextInt();
            p = sc.nextInt();

            cache = new double[n][d+1];
            connected = new int[n][n];
            deg = new int[n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    connected[i][j] = sc.nextInt();
                    if(connected[i][j] == 1) {
                        deg[i]++;
                    }
                }
            }

            int t = sc.nextInt();

            double ret = 0;
            for(int i=0; i<t; i++){
                q = sc.nextInt();
                initialize();
                ret = search(p, 0);
                System.out.println(ret);
            }
        }

        sc.close();
    }

    static void initialize(){
        for(int i=0; i<n; i++){
            for(int j=0; j<=d; j++){
                cache[i][j] = -1;
            }
        }
    }

    static double search(int here, int days){
        if(days == d) return here == q ? 1.0 : 0.0;

        if(cache[here][days] != -1) return cache[here][days];

        double ret = 0.0;

        for(int there = 0; there < n; there++){
            if(connected[here][there] == 1){
                ret += search(there, days+1) / deg[here];
            }
        }

        cache[here][days] = ret;
        return ret;
    }
    
}
