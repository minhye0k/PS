import java.util.*;

public class knapsack{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N, K;

        N = sc.nextInt();
        K = sc.nextInt();

        int[][] goods = new int[N+1][2];

        for(int i=1; i<=N; i++){
            goods[i][0] = sc.nextInt();
            goods[i][1] = sc.nextInt();
        }

        int[][] d = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                int v = goods[i][1];
                int w = goods[i][0];

                if(w > j) d[i][j] = d[i-1][j];
                else{
                    d[i][j] = Math.max(d[i-1][j], d[i-1][j-w] + v);
                }
            }
        }

        System.out.println(d[N][K]);
    }
}