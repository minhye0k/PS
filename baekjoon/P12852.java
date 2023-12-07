import java.util.*;

public class P12852 {

    static int[] result;
    static int N;

    static void print(int x){
        if(x != N)
            print(result[x]);
        System.out.print(x + " "); 
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[N] = 0;

        result = new int[N+1];

        for(int i=N; i>0; i--){
            if(i%3 == 0){
                if(dp[i] + 1 < dp[i/3]){
                    dp[i/3] = dp[i] + 1;
                    result[i/3] = i;
                }
                
            }
            if(i%2 == 0){
                if(dp[i] + 1 < dp[i/2]){
                    dp[i/2] = dp[i] + 1;
                    result[i/2] = i;
                }
            }

            if(dp[i] + 1 < dp[i-1]){
                dp[i-1] = dp[i] + 1;
                result[i-1] = i;
            }
        }

        System.out.println(dp[1]);
        
        print(1);

        sc.close();
    }
}
