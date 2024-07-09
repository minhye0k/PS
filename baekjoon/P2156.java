import java.io.*;

public class P2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] amounts = new int[n+1];

        for(int i=0; i<n; i++){
            int amount = Integer.parseInt(br.readLine());
            amounts[i+1] = amount;
        }


        int[] dp = new int[n+1];
        dp[1] = amounts[1];
        

        if(n == 1){
            bw.write(dp[1] + "\n");
            bw.flush();
            return;
        }
        dp[2] = dp[1] + amounts[2];

        if (n==2) {
            bw.write(dp[2] + "\n");
            bw.flush();
            return;
        }


        for(int i=3; i<=n ;i++){
            dp[i] = Math.max(dp[i-3] + amounts[i-1] + amounts[i], Math.max(dp[i-2] + amounts[i], dp[i-1]));
        }

        bw.write(dp[n] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
