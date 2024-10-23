import java.util.*;
import java.io.*;

public class Christmas {
    static int N, K;
    static int[] D, psum; 
    static final int MOD = 20091101;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);

            D = new int[N];
            psum = new int[N+1];

            K = Integer.parseInt(s[1]);

            String[] input = br.readLine().split(" ");
            psum[0] = 0;
            psum[1] = Integer.parseInt(input[0]) % K;

            for(int i=2; i<=N; i++){
                int n = Integer.parseInt(input[i-1]);
                psum[i] = (psum[i-1] + n) % K;
            }

            waysToBuy();
            maxBuys();
        }


        br.close();
        bw.close();


    }

    static void waysToBuy(){
        long[] cnt = new long[K];

        for(int i=0; i<=N; i++){
            cnt[psum[i]]++;
        }

        int ret = 0;

        for(int i=0; i<K; i++){
            if(cnt[i] >= 2){
                ret = (int)((ret +((cnt[i] * (cnt[i]-1)) / 2)) % MOD);
            }
        }

        System.out.print(ret + " ");
    }

    static void maxBuys(){
        int[] ret = new int[N+1];
        int[] prev = new int[K];
        Arrays.fill(prev, -1);
        ret[0] = 0;
        prev[psum[0]] = 0;

        for(int i=1; i<=N; i++){
            ret[i] = ret[i-1];

            int loc = prev[psum[i]];
            if(loc != -1) ret[i] = Math.max(ret[i], ret[loc] + 1);

            prev[psum[i]] = i;
        }

        System.out.println(ret[N]);
    }
    
}
