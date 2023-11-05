import java.util.*;

public class P2178 {
    static int N, M;
    static boolean[][] isVisited;
    static int[][] board;

    static int []dx = {0,1,0,-1};
    static int []dy = {1,0,-1,0};

    public static int bfs(){
        int ret = 0;

        Queue<Pair> q = new LinkedList();

        q.add(new Pair(0,0,1));
        isVisited[0][0] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            
            if(p.x == N-1 && p.y == M-1) return p.dist;

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(OOB(nx,ny) || board[nx][ny] == 0 || isVisited[nx][ny]) continue;
                q.add(new Pair(nx,ny, p.dist+1));
                isVisited[nx][ny] = true;
            }

        }

        return ret;
    }

    public static boolean OOB(int x, int y){
        return x < 0 || x >=N || y<0 || y >=M;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        isVisited = new boolean[N][M];
        
        sc.nextLine();

        for(int i=0; i<N; i++){
            String line = sc.nextLine();

            for(int j=0; j<line.length(); j++){
                board[i][j] = line.charAt(j) - '0';                
            }
        }

        sc.close();

        System.out.println(bfs());
    }
}

class Pair{
    public int x;
    public int y;
    public int dist;

    public Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
