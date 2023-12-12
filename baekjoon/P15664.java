import java.util.*;

public class P15664 {
    static int N,M;
    static int[] arr;
    static int[] num;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    static Map<String, Boolean> m = new HashMap<>();

    static void dfs(int depth, int start){
        if(depth == M){
            StringBuilder tsb = new StringBuilder();
            for(int i=0; i<M; i++){
                tsb.append(arr[i] + " ");
            }
            if(m.containsKey(tsb.toString())){
                return;
            }
            m.put(tsb.toString(), true);
            
            sb.append(tsb.toString());
            sb.append('\n');
            return;
        }

        for(int i=start; i<N; i++){
            if(isVisited[i]) continue;

            isVisited[i] = true;
            arr[depth] = num[i];
            dfs(depth+1, i+1);
            isVisited[i] = false;
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        num = new int[N];
        isVisited = new boolean[N];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        dfs(0, 0);

        System.out.println(sb);

        sc.close();
    }
    
}
