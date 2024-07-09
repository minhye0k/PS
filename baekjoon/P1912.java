import java.util.*;
import java.io.*;

public class P1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        String[] numberStrs = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(numberStrs[i]);
            numbers[i] = number;
        }

        int[] dp = new int[n];
        int answer = numbers[0];
        dp[0] = numbers[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
            answer = Math.max(answer, dp[i]);
        }

        bw.write(answer + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
