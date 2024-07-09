import java.util.*;
import java.io.*;

public class P11058 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 추가 or 복사
        1. A 출력하기 -> dp[i-1] + 1
        2. 
        3. Ctrl-A, Ctrl-C, Ctrl-V
        */

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1] + 1;
            for(int j=3; j<i; j++){
                dp[i] = Math.max(dp[i-j] * (j-1), dp[i]);
            }
            
        }

        bw.write(dp[N] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
