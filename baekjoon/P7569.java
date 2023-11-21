import java.util.*;

public class P7569 {
    static int M,N,H;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int dz[] = {1,-1};
    static int map[][][];
    static Queue<Coordinate> q = new LinkedList<>();
    static int result = 0;

    static class Coordinate{
        int z;
        int x;
        int y;
        int day;

        Coordinate(int z,int x, int y, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day; 
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    map[i][j][k] = sc.nextInt();
                    if(map[i][j][k] == 1){
                        q.add(new Coordinate(i,j,k,0));
                    }
                }
            }
        }

        sc.close();

        bfs();

        if(!allIsRipe()){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }

    static void bfs(){
        
        while(!q.isEmpty()){
            Coordinate c = q.poll();

            for(int i=0; i<4; i++){
                int nx = dx[i] + c.x;
                int ny = dy[i] + c.y;

                if(OOB(c.z,nx,ny) || map[c.z][nx][ny] != 0) continue;

                q.add(new Coordinate(c.z, nx, ny, c.day+1));
                map[c.z][nx][ny] = 1;
            }

            for(int i=0; i<2; i++){
                int nz = dz[i] + c.z;

                if(OOB(nz, c.x, c.y) || map[nz][c.x][c.y] != 0) continue;

                q.add(new Coordinate(nz, c.x, c.y, c.day+1));
                map[nz][c.x][c.y] = 1;
            }
            
            result = Math.max(result,c.day);
            
        }
    }

    static boolean OOB(int z, int x, int y){
        return z<0 || x <0 || y<0 || z>=H || x >= N || y >= M; 
    }

    static boolean allIsRipe(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k] == 0) return false;
                }
            }
        }

        return true;
    }

    

}
