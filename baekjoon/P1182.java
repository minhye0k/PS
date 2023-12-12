import java.util.*;

public class P1182 {

    static int N;
    static int S;
    static int arr[];
    static int arr2[];
    static int answer = 0;
    static boolean isVisited[];

    static void dfs(int depth, int start){
        if(depth > N) return;

        int sum = 0;
        if(depth!=0){
            for(int i=0; i<depth; i++){
                sum += arr2[i];
            }
            if(sum==S) answer++;
        }   

        for(int i=start; i<N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                arr2[depth] = arr[i];
                dfs(depth+1, i+1);
            }

            isVisited[i] = false;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        arr2 = new int[N];

        isVisited = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        dfs(0,0);

        System.out.println(answer);
        

        sc.close();
    }
    
}
