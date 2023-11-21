import java.util.*;

public class P10026 {
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1,0,-1,0};
    static char map[][];
    static boolean isVisited[][];
    static int N;

    static class Pair {
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, boolean abnormal){
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x,y));
        isVisited[x][y] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int i=0; i<4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if(OOB(nx,ny) || isVisited[nx][ny]) continue;
                if(!isSame(map[x][y], nx, ny, abnormal)) continue;

                q.add(new Pair(nx,ny));
                isVisited[nx][ny] = true;
            }
        }
    }

    static boolean OOB(int x, int y){
        return x < 0 || y < 0 || x >= N || y >=N;
    }

    static boolean isSame(char current, int x,int y, boolean abnormal){
        if(map[x][y] == current) return true;
        
        if(abnormal){
            if(current == 'R'){
                if(map[x][y] == 'G') return true;
            }else if(current == 'G'){
                if(map[x][y] == 'R') return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new char[N][N];
        isVisited = new boolean[N][N];

        sc.nextLine();

        for(int i=0; i<N; i++){
            String buffer = sc.nextLine();

            for(int j=0; j<buffer.length(); j++){
                map[i][j] = buffer.charAt(j);
            }
        }

        sc.close();


        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(isVisited[i][j]) continue;
                bfs(i,j,false);
                cnt++;
            }
        }

        System.out.print(cnt + " ");
        cnt = 0;
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(isVisited[i][j]) continue;
                bfs(i,j,true);
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
