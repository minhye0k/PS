import java.util.*;

public class P2468{
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int N;

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int k){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        isVisited[x][y] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(OOB(nx,ny) || isVisited[nx][ny] || map[nx][ny] <= k) continue;

                q.add(new Pair(nx,ny));
                isVisited[nx][ny] = true;
            }
        }
    }

    static boolean OOB(int x,int y){
        return x < 0 || y < 0 || x >=N || y>=N;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        int maxHeight = 0, result = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        sc.close();

        for(int k=1; k<=maxHeight; k++){
            int count = 0;
            isVisited = new boolean[N][N];
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!isVisited[i][j] && map[i][j] > k){
                        bfs(i,j,k);
                        count++;
                    }
                }
            }

            result = Math.max(count, result);

        }

        System.out.println(result);
    }

}