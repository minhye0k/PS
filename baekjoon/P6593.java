import java.util.*;

public class P6593 {
    static char[][][] building;
    static int L, R, C;

    static int dz[] = {1,-1};
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    static class Pair{
        int z;
        int x;
        int y;
        int cnt;

        Pair(){

        }

        Pair(int z, int x, int y, int cnt){
            this.z = z;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
    }

    static void bfs(Pair sp, Pair ep){
        Queue<Pair> q = new LinkedList<>();

        q.add(sp);
        building[sp.z][sp.x][sp.y] = '#';

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(p.x == ep.x && p.z == ep.z && p.y == ep.y){
                System.out.println("Escaped in " + p.cnt + " minute(s).");
                return;
            }

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(OOB(p.z, nx, ny) || building[p.z][nx][ny] == '#') continue;

                q.add(new Pair(p.z, nx, ny, p.cnt+1));
                building[p.z][nx][ny] = '#';

            }

            for(int i=0; i<2; i++){
                int nz = p.z + dz[i];
                
                if(OOB(nz, p.x, p.y) || building[nz][p.x][p.y] == '#') continue;

                q.add(new Pair(nz, p.x, p.y, p.cnt+1));
                building[nz][p.x][p.y] = '#';
            }


        }

        System.out.println("Trapped!");


    }

    static boolean OOB(int z, int x, int y){
        return z < 0 || x < 0 || y < 0 || z >= L || x >= R || y >= C;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while(true){
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if(L == 0 && R == 0 && C == 0) break;

            sc.nextLine();

            building = new char[L][R][C];

            Pair sp = new Pair(); 
            Pair ep = new Pair();

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String s = sc.nextLine();
                    for(int k=0; k<C; k++){
                        building[i][j][k] = s.charAt(k);
                        if(building[i][j][k] == 'S'){
                            sp = new Pair(i,j,k,0);
                        }else if(building[i][j][k] == 'E'){
                            ep = new Pair(i,j,k,0);
                        }
                    }
                }
                sc.nextLine();
            }

            bfs(sp, ep);

        }

        sc.close();
    }
    
}
