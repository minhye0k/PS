import java.util.*;

public class P4179 {
    static char[][] miro;
    static boolean[][] isVisited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<Pair> fq = new LinkedList<>();

    static int R,C;

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean OOB(int x, int y){
        return x >= R || y >= C || x < 0 || y < 0;
    }

    public static boolean isSuccess(Pair p){
        return p.x == 0 || p.x == R-1 || p.y == 0 || p.y == C-1;
    }

    public static void bfs(Pair jp){
        Queue<Pair> jq = new LinkedList<>();        
        jq.add(jp);

        isVisited[jp.x][jp.y] = true;

        int cnt = 0;
        
        while(true){
            int fsize = fq.size();
            while(fsize != 0){
                fsize--;
                Pair p = fq.poll();

                for(int i=0; i<4; i++){
                    int nx = dx[i] + p.x;
                    int ny = dy[i] + p.y;

                    if(OOB(nx,ny) || miro[nx][ny] == '#' || miro[nx][ny] == 'F') continue;

                    miro[nx][ny] = 'F';
                    fq.add(new Pair(nx,ny));
                }
            }

            int jsize = jq.size();
            while(jsize != 0){
                jsize--;
                Pair p = jq.poll();
                if(isSuccess(p)) {
                    System.out.println(cnt+1);
                    return;
                }
                
                for(int i=0; i<4; i++){
                    int nx = dx[i] + p.x;
                    int ny = dy[i] + p.y;

                    if(OOB(nx,ny) || isVisited[nx][ny] || miro[nx][ny] != '.') continue;
                    
                    isVisited[nx][ny] = true;
                    jq.add(new Pair(nx,ny));
                }

            }
            if(jq.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }

            cnt++;


        }


    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        miro = new char[R][C];
        isVisited = new boolean[R][C];

        Pair jp = new Pair(0,0);

        sc.nextLine();

        for(int i=0; i<R; i++){
            String s = sc.nextLine();
            for(int j=0; j<C; j++){
                miro[i][j] = s.charAt(j);
                if(miro[i][j] == 'J'){
                    jp = new Pair(i,j);
                }else if(miro[i][j] == 'F'){
                    fq.add(new Pair(i,j));
                }
            }
        }
        
        bfs(jp);

    }
    
}
