import java.util.*;
import java.io.*;

public class P14502 {

    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;

    static int[][] labor;
    static int N, M;

    static int result = 0;

    static boolean[][] isVisited;

    static List<Pair> walls = new ArrayList<>();
    static List<Pair> viruses = new ArrayList<>();

    static int safe = 0;

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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] numbers = input.split(" ");

        N = Integer.parseInt(numbers[0]);
        M = Integer.parseInt(numbers[1]);

        labor = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine();
            numbers = input.split(" ");
            for(int j=0; j<M; j++){
                labor[i][j] = Integer.parseInt(numbers[j]);
                if(labor[i][j] == EMPTY) safe++;
                if(labor[i][j] == VIRUS){
                    viruses.add(new Pair(i,j));
                }
            }
        }

        // System.out.println(safe);

        // print();

        dfs(0,0,0);

        bw.write(result + "\n");
        bw.flush();


        br.close();
        bw.close();
    }

    static void dfs(int cnt, int x, int y){
        if(cnt == 3){
            // print();
            int virusCount = bfs();
            result = Math.max(result, safe - 3 - virusCount);

            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(labor[i][j] != EMPTY) continue;
                labor[i][j] = WALL;
                dfs(cnt+1,i,j);
                labor[i][j] = EMPTY;
            }
        }
    }

    static int bfs(){
        int cnt = -1 * viruses.size();

        Queue<Pair> q = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];
        
        for(Pair virus : viruses){
            q.add(virus);
            int x = virus.x;
            int y = virus.y;

            visited[x][y] = true;
        }

        while(!q.isEmpty()){
            cnt++;

            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(OOB(nx,ny) || visited[nx][ny] || labor[nx][ny] != EMPTY) continue;

                q.add(new Pair(nx,ny));
                visited[nx][ny] = true;
            }
        }

        return cnt;
    }

    static boolean OOB(int x, int y){
        return x<0 || x >= N || y < 0 || y>=M;
    }

    static void print(){
        System.out.println();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(labor[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
