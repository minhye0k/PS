import java.util.*;

public class P15656 {

    static int N,M;
    static int[] arr;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = num[i];
            dfs(depth+1, i);
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        dfs(0, 0);

        System.out.println(sb);

        sc.close();
    }
    
}
