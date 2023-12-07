import java.util.*;

public class P11659 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] num = new int[N+1];
        int[] sum = new int[N+1];
        
        for(int i=1; i<=N; i++){
            num[i] = sc.nextInt();
        }


        for(int i=1; i<=N; i++){
            sum[i] = num[i]+ sum[i-1];
        }

        for(int k=0; k<M; k++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(sum[j] - sum[i-1]);
        }



        sc.close();

    }
    
}
