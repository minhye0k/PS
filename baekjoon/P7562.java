import java.util.*;

public class P7562 {
    static int l;
    static int sx, sy, ex, ey;
    static int dx[] = {-1,-2,-1,-2,1,2,1,2};
    static int dy[] = {-2,-1,2,1,-2,-1,2,1};

    static int board[][];
    static boolean isVisited[][];

    static class Pair{
        int x;
        int y;
        int cnt;

        Pair(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy, 0));
        isVisited[sx][sy] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(p.x == ex && p.y == ey){
                return p.cnt;
            }

            for(int i=0; i<8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(OOB(nx,ny) || isVisited[nx][ny]) continue;
                q.add(new Pair(nx,ny,p.cnt+1));
                isVisited[nx][ny] = true;
            }
        }

        return 0;
    }

    static boolean OOB(int x, int y){
        return x <0 || y <0 || x >= l || y >= l;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int t=0; t<T; t++){
            l = sc.nextInt();
            isVisited = new boolean[l][l];
            board = new int[l][l];

            sx = sc.nextInt();
            sy = sc.nextInt();

            ex = sc.nextInt();
            ey = sc.nextInt();

            System.out.println(bfs());
        }


        sc.close();
    }  
}
