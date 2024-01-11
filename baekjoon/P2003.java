import java.util.*;

public class P2003{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        sc.close();

        int start = 0, end = 0, sum = 0, result = 0;

        while(true){
            if(sum > M){
                sum -= arr[start++];
            }else if(sum == M){
                result++;
                sum -= arr[start++];
            }else if(end >= N){
                break;
            }else{
                sum += arr[end++];
            }
        }

        System.out.println(result);

    }
}