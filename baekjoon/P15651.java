import java.util.*;

public class P15651 {

    static int N,M;
    static int[] arr;
    static StringBuffer sb = new StringBuffer();

    static void dfs(int depth){
        if(depth == M){
            
            for(int i=0; i<M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            arr[depth] = i;
            dfs(depth+1);
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];

        dfs(0);
        System.out.println(sb);

        sc.close();
    }
}
