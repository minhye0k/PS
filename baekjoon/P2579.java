import java.util.*;

public class P2579 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stairs = new int[n+1];

        int[][] dp = new int[n+1][2];

        for(int i=1; i<=n; i++){
            stairs[i] = sc.nextInt();
        }

        dp[1][0] = stairs[1];
        dp[1][1] = stairs[1];

        if(n >= 2){
            dp[2][1] = stairs[1] + stairs[2];
            dp[2][0] = stairs[2];
        }
        
        if(n>=3){
            dp[3][0] = stairs[1] + stairs[3];
            dp[3][1] = stairs[2] + stairs[3];
        }

        for(int i=4; i<=n; i++){
            dp[i][1] = stairs[i] + dp[i-1][0];
            dp[i][0] = stairs[i] + Math.max(dp[i-2][1], dp[i-2][0]);
        }

        System.out.println(Math.max(dp[n][1], dp[n][0]));

        sc.close();
    }
    
}
