import java.io.*;
import java.util.*;

public class P11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N+1];

        String s = br.readLine();
        String[] numbers = s.split(" ");
        for(int i=0; i<N; i++){
            A[i+1] = Integer.parseInt(numbers[i]);
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, 1);

        dp[0] = 0;

        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ret = 0;
        for(int i=1; i<=N; i++){
            ret = Math.max(ret, dp[i]);
        }

        bw.write(ret + "\n");
        bw.flush();
        
        
        br.close();
        bw.close();
    }    
}
