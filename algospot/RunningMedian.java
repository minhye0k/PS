import java.util.*;

public class RunningMedian {
    static final int MOD = 20090711;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0) {
            int N = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            solve(N, a, b);

        }

        sc.close();
    }

    static void solve(int N, int a, int b){
        int ret = 0;

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int A = 1983;
        for(int i=0; i<N; i++){
            int maxSize = max.size();
            int minSize = min.size();

            if(maxSize == minSize){
                max.add(A);
            }else{
                min.add(A);
            }

            if(!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek()){
                int x = max.poll();
                int y = min.poll();

                min.add(x);
                max.add(y);
            }

            ret = (ret + max.peek()) % MOD;

            long tmp = ((long)A * (long)a + (long)b);
            tmp %= MOD;
            A = (int) tmp;
            
        }

        System.out.println(ret);
    }
    
}
