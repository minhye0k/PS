import java.util.*;

public class Strjoin {
    static int n;
    static int[] lengths;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();
            lengths = new int[n];

            for(int i=0; i<n; i++){
                lengths[i] = sc.nextInt();
            }

            System.out.println(join());
        }
        sc.close();
    }

    static int join() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(lengths[i]);
        }

        int ret = 0;
        while(pq.size() > 1){
            
            int min1 = pq.poll();
            int min2 = pq.poll();
            pq.add(min1+min2);

            ret += min1 + min2;
        }

        return ret;
    }
    
}
