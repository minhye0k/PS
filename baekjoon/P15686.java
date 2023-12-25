import java.util.*;

public class P15686 {

    static int N, M;
    static int[][] map;
    static List<Pair> chickens = new ArrayList<>();
    static List<Pair> homes = new ArrayList<>();

    static Pair[] pairs;

    static int[] ints;
    static boolean[] isVisited;

    static int result = Integer.MAX_VALUE;

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];

        ints = new int[M];
        pairs = new Pair[M];
        

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    homes.add(new Pair(i,j));
                }else if(map[i][j] == 2){
                    chickens.add(new Pair(i,j));
                }
            }
        }

        isVisited = new boolean[chickens.size()];

        dfs(0,0);
        System.out.println(result);

        sc.close();
    }

    static void dfs(int depth, int start){
        if(depth == M){
            int mini = getMinimumDistance();
            result = Math.min(result, mini);

            return;
        }

        for(int i=start; i<chickens.size(); i++){
            if(!isVisited[i]){
                pairs[depth] = chickens.get(i);
                isVisited[i] = true;
                dfs(depth+1, i);
                isVisited[i] = false;
            }

        }
    }

    static int getMinimumDistance(){
        int ret = 0;

        for(Pair p : homes){
            int mini = Integer.MAX_VALUE;
            
            int x = p.x;
            int y = p.y;
            for(int j=0; j<M; j++){
                Pair chi = pairs[j];
                int dist = Math.abs(chi.x - x) + Math.abs(chi.y -y);
                mini = Math.min(dist, mini);
            }
            ret += mini;
        }

        return ret;
    }


    
}
