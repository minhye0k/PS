import java.util.*;

public class P5427 {
    static char[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int w,h;
    static boolean[][] isVisited;

    static Queue<Pair> fq;
    static Queue<Pair> sq;
    
    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        int cnt = 0;

        while(true){
            cnt++;

            if(sq.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            int fqSize = fq.size();
            for(int i=0; i<fqSize; i++){
                Pair p = fq.poll();
                for(int j=0; j<4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if(OOB(nx,ny) || map[nx][ny] == '*' || map[nx][ny] == '#') continue;
                    map[nx][ny] = '*';
                    fq.add(new Pair(nx,ny));
                }
            }

            int sqSize = sq.size();
            for(int i=0; i<sqSize; i++){
                Pair p = sq.poll();
                if(exitable(p.x, p.y)){
                    System.out.println(cnt);
                    return;
                }

                for(int j=0; j<4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if(OOB(nx,ny) || map[nx][ny] != '.' || isVisited[nx][ny]) continue;

                    sq.add(new Pair(nx,ny));
                    isVisited[nx][ny] = true;
                }
                
            }


        }

    }

    static boolean OOB(int x, int y){
        return x <0 || y <0 || x >= h || y >=w;
    }

    static boolean exitable(int x, int y){
        return x == 0 || y == 0 || x == h-1 || y ==w-1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            w = sc.nextInt();
            h = sc.nextInt();

            map = new char[h][w];
            
            fq = new LinkedList<>();
            sq = new LinkedList<>();
            isVisited = new boolean[h][w];

            sc.nextLine();

            for(int j=0; j<h; j++){
                String buffer = sc.nextLine();
                for(int k=0; k<w; k++){
                    map[j][k] = buffer.charAt(k);
                    if(map[j][k] == '@'){
                        sq.add(new Pair(j,k));
                        isVisited[j][k] = true;
                    }else if(map[j][k] == '*'){
                        fq.add(new Pair(j,k));
                    }
                }
            }
            
            bfs();
        }

        sc.close();

    }
    
}
