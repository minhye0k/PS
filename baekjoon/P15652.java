import java.util.*;

public class P15652 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i=start; i<=N; i++){
            arr[depth] = i;
            dfs(depth+1, i);
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];

        dfs(0,1);

        System.out.println(sb);

        sc.close();
    }
}
