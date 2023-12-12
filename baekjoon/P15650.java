import java.util.*;

public class P15650 {
    static int N,M;
    static int[] arr;

    static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for(int i=start; i<=N; i++){
            arr[depth] = i;
            dfs(depth+1, i+1);
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];

        dfs(0,1);

        sc.close();
    }
}
