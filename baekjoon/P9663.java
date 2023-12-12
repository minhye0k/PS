import java.util.*;

public class P9663 {

    static int N;
    static int[] col;
    static int answer = 0;

    static void dfs(int depth) {
        if(depth == N){
            answer++;
            return;
        }

        for(int i=0; i<N; i++){
            col[depth] = i;
            if(isPossible(depth)){
                dfs(depth+1);
            }
        }
    }

    static boolean isPossible(int c){
        for(int i=0; i<c; i++){
            if(col[i] == col[c]) return false;

            if(Math.abs(col[i] - col[c]) == Math.abs(i - c)) return false;
        }

        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        col = new int[N];
        dfs(0);

        System.out.println(answer);

        sc.close();
    }
}
