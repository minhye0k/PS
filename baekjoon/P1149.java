import java.util.*;

public class P1149 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 0 : R , 1 : G , 2 : B

        int[][] cost = new int[n+1][3];

        for(int i=1; i<=n; i++){
            for(int j=0; j<3; j++){
                cost[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n+1][3];
        
        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        

        dp[0][1] = dp[0][0] = dp[0][2] = 0;

        for(int i=1; i<=n; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    if(j==k) continue;
                    dp[i][j] = Math.min(dp[i][j], cost[i][j] + dp[i-1][k]); 
                }
            }
        }

        sc.close();

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }

    
}
