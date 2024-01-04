import java.util.*;

public class P2230 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int A[] = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(A);

        int result = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        while(start <= end){
            int diff = A[end] - A[start];
            if(diff >= M){
                result = Math.min(result,diff);
                start++;
            }else{
                end++;
            }

            if(end >= N) break;
        }

        System.out.println(result);


    }
}
