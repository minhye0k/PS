import java.util.*;
import java.io.*;

public class P17218 {
    static String a;
    static String b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = br.readLine();
        b = br.readLine();

        int aLength = a.length();
        int bLength = b.length();

        int[][] dp = new int[aLength+1][bLength+1];

        for(int i=1; i<=aLength; i++){
            for(int j=1; j<=bLength; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        String LCS = getLCS(aLength,bLength, dp);

        bw.write(LCS + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    static String getLCS(int x, int y, int[][] dp){
        StringBuilder sb = new StringBuilder();

        if(x == 0 || y == 0) return "";

        if(dp[x][y] == dp[x-1][y]){
            sb.append(getLCS(x-1, y, dp));
        }else if(dp[x][y] == dp[x][y-1]){
            sb.append(getLCS(x, y-1, dp));
        }else{
            sb.append(getLCS(x-1, y-1, dp)).append(a.charAt(x-1));
        }

        return sb.toString();
    }
    
}
