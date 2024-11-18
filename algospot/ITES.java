import java.util.*;

public class ITES {

    static final long MOD = (long) Math.pow(2, 32);
    static int N, K;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            K = sc.nextInt();
            N = sc.nextInt();
            solve();
        }

        sc.close();
    }

    static void solve(){

        Queue<Long> q = new LinkedList<>();

        int ret = 0;

        long sum = 0;
        long a = 1983;

        int n = 0;
        while(true){            
            // System.out.println(signal);
            
            if(sum < K){
                long newA = (a * 214013 + 2531011) % MOD;
                long signal = (long) newA % 10000 + 1;

                sum += signal;
                q.add(signal);
                
                n++;
                a = newA;
            }else{
                if(q.isEmpty()) continue;
                sum -= q.poll();
            }

            
            if(sum == K) ret++;

            if(n>=N) break;
        }

        System.out.println(ret);
    }
    
}
