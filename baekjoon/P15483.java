import java.util.*;
import java.io.*;

public class P15483 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();

        int aLength = A.length();
        int bLength = B.length();

        int[][] dp = new int[aLength+1][bLength+1];

        for(int i=0; i<=aLength; i++){
            dp[i][0] = i;
        }

        for(int i=0; i<=bLength; i++){
            dp[0][i] = i;
        }

        /*
        A[i][j-1] : 삽입
        A[i-1][j] : 삭제
        A[i-1][j-1] : 교체 or 유지

        bca -> ab
        bc -> abc

        bc -> ab
        */

        for(int i=1; i<=aLength; i++){
            for(int j=1; j<=bLength; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
            }
        }

        bw.write(dp[aLength][bLength] + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
    
}
