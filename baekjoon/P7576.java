import java.util.*;

public class P7576 {
    static int[][] box;
    static int N, M;
    static Queue<Pair> q = new LinkedList<>();

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static boolean OOB(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    public static int bfs(){
        int ret = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();

            ret = Math.max(ret, p.d);

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(OOB(nx,ny) || box[nx][ny] != 0) continue;

                q.add(new Pair(nx,ny,p.d+1));
                box[nx][ny] = p.d+1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0) return -1;
            }
        }

        return ret-1;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        box = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1)
                    q.add(new Pair(i,j,1));
                
            }
        }

        sc.close();

        System.out.println(bfs());

    }
    
}

class Pair{
    int x;
    int y;
    int d;

    public Pair(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
