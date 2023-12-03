import java.util.*;

public class P2667 {
    static int map[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    static int N;

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
        map[x][y] = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            ret++;

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(OOB(nx,ny) || map[nx][ny] == 0) continue;

                q.add(new Pair(nx,ny));
                map[nx][ny] = 0;
            }
        }

        return ret;
    }

    static boolean OOB(int x, int y){
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        sc.nextLine();
        for(int i=0; i<N; i++){
            String s = sc.nextLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        sc.close();

        List<Integer> results = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1){
                    results.add(bfs(i,j));
                }
            }
        }

        Collections.sort(results);

        System.out.println(results.size());
        results.forEach(
            System.out::println
        );


    }
    
}
