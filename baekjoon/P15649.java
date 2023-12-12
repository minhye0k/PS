import java.util.*;

public class P15649 {

    static List<Integer> list = new ArrayList<>();
    static boolean[] isVisited;

    static int N,M;

    static void dfs(int m){
        if(list.size() == M){
            list.forEach((i) -> System.out.print(i + " "));
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            list.add(i);
            dfs(m+1);
            isVisited[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        isVisited = new boolean[N+1];

        dfs(0);

        sc.close();
    }
    
}
