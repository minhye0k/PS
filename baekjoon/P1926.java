import java.util.*;

class Pair{
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    int x;
    int y;
}

public class P1926{
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static boolean OOB(int x, int y){
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    public static int bfs(int x, int y){
        int ret = 0;

        Queue<Pair> q = new LinkedList();

        q.add(new Pair(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();

            int cx = p.x;
            int cy = p.y;

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(OOB(nx,ny) || visited[nx][ny] || paper[nx][ny] == 0) continue;
                
                q.add(new Pair(nx,ny));
                visited[nx][ny] = true;

            }

            ret++;
        }

        return ret;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        
        paper = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        sc.close();
        
        int count = 0;
        int width = 0;


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && paper[i][j] == 1) {
                    width = Math.max(bfs(i,j), width);
                    count++;
                }
                
            }
        }

        System.out.println(count);
        System.out.println(width);
    }
}
