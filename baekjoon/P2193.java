import java.util.*;

public class P2193 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        long[][] d = new long[N+1][2];

        // 앞에 0일땐 뒤에 1,0 모두 옴
        // 앞에 1일땐 뒤에 0만 옴

        d[1][1] = 1;

        for(int i=2; i<=N; i++){
            d[i][1] = d[i-1][0];
            d[i][0] = d[i-1][1] + d[i-1][0];
        }

        System.out.println(d[N][1] + d[N][0]);

        sc.close();
    }
    
}
