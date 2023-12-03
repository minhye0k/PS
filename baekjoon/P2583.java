import java.util.*;
import java.util.stream.Collectors;

public class P2583 {
    static int[][] paper;
    static boolean[][] isVisited;
    static int M,N;

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

    static int bfs(int x, int y){
        int ret = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x,y));
        isVisited[x][y] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            ret++;

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(OOB(nx,ny) || isVisited[nx][ny] || paper[nx][ny] == 1) continue;
                q.add(new Pair(nx,ny));
                isVisited[nx][ny] = true;
            }
        }

        return ret;
    }

    static boolean OOB(int x, int y){
        return x < 0 || y < 0 || x>=M || y >= N;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();

        paper = new int[M][N];
        isVisited = new boolean[M][N];

        int K = sc.nextInt();

        for(int i=0; i<K; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int j=y1; j<y2;j++){
                for(int k=x1; k<x2; k++){
                    paper[j][k] = 1;
                }
            }
        }

        sc.close();

        List<Integer> results = new ArrayList<>();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!isVisited[i][j] && paper[i][j] == 0){
                    results.add(bfs(i,j));
                }
            }
        }
        results = results.stream().sorted().collect(Collectors.toList());
        
        System.out.println(results.size());
        results.stream().forEach(
            r -> System.out.print(r + " ")
        );
    }
}
