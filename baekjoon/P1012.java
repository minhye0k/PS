import java.util.*;

public class P1012{
    static int M, N;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if(OOB(nx,ny) || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.add(new Pair(nx,ny));
                visited[nx][ny] = true;
            }
        }
    }

    public static boolean OOB(int x, int y){
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int j=0; j<K; j++){
                int y = sc.nextInt();
                int x = sc.nextInt();

                map[x][y] = 1;
            }
            int cnt = 0;
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(!visited[n][m] && map[n][m] == 1){
                        bfs(n, m);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

        sc.close();
    


    }
}