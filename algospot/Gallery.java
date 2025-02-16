import java.util.*;


public class Gallery {
    static int[][] adj;
    static boolean[] isVisited;
    static int installed;
    static int G;

    static final int WATCHED = 0;
    static final int UNWATCHED = 1;
    static final int INSTALLED = 2;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            G = sc.nextInt();

            adj = new int[G][G];
            isVisited = new boolean[G];

            int H = sc.nextInt();

            for(int i=0; i<H; i++){
                int v = sc.nextInt();
                int u = sc.nextInt();

                adj[v][u] = 1;
                adj[u][v] = 1;
            }
            installCamera();
            System.out.println(installed);
        }

        sc.close();
    }

    static void installCamera(){
        installed = 0;

        for(int i=0; i<G; i++){
            if(!isVisited[i] && dfs(i) == UNWATCHED) installed++;
        }
    }

    static int dfs(int here){
        isVisited[here] = true;
        int[] status = {0, 0, 0};

        for(int there=0; there<G; there++){
            if(adj[here][there] != 0 && !isVisited[there]){
                status[dfs(there)]++;
            }
        }

        if(status[UNWATCHED] > 0) {
            installed++;
            return INSTALLED;
        }

        if(status[INSTALLED] > 0){
            return WATCHED;
        }

        return UNWATCHED;


    }
}
