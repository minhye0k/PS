import java.util.*;

public class P1806 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int result = Integer.MAX_VALUE;

        int start = 0;
        int sum = 0;
        int end = 0;

        int length = 0;

        while(start <= end){
            if(sum >= S){
                sum -= arr[start++];
                length--;
            }else{
                if(end<N){
                    sum += arr[end++];
                    length++;
                }else{
                    break;
                }
            }

            if(sum >=S){
                result = Math.min(result, length);
            }

            if(start >= N-1) break;

        }

        sc.close();

        if(result == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
        
    }
}
