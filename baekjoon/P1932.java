import java.util.*;

public class P1932 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] d = new int[n+1][n+1];
        int[][] score = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                score[i][j] = sc.nextInt();
            }
        }

        d[1][1] = score[1][1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){                
                if(j-1>=1) d[i][j] = Math.max(d[i][j], score[i][j] + d[i-1][j-1]);
                if(j!=i) d[i][j] = Math.max(d[i][j], score[i][j] + d[i-1][j]);
            }
        }

        
        System.out.println(Arrays.stream(d[n]).max().getAsInt());
        
        sc.close();
    }
}
