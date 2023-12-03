import java.util.*;

public class P9095 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int dp[] = new int[12];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<12; i++){
            dp[i] += dp[i-1];
            dp[i] += dp[i-2]; 
            dp[i] += dp[i-3];
        }

        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }

    }
    
}
