import java.util.*;

public class P11559 {

    static char[][] ppuyo = new char[12][6];
    static boolean[][] isVisited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<12; i++){
            String s = sc.nextLine();
            for(int j=0; j<6; j++){
                ppuyo[i][j] = s.charAt(j);
            }
        }

        int result = 0;

        while(true){
            int cnt = 0;
            isVisited = new boolean[12][6];

            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(ppuyo[i][j] == '.' || isVisited[i][j]) continue;
                    boolean success = bfs(i, j);
                    if(success) cnt++;
                }
            }

            if(cnt == 0) break;

            down();
            print();
            result++;
        }

        System.out.println(result);

        sc.close();
    }

    static boolean bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();

        char c = ppuyo[x][y];

        q.add(new Pair(x,y));
        isVisited[x][y] = true;
        
        Queue<Pair> qq = new LinkedList<>();
        qq.add(new Pair(x,y));

        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(OOB(nx,ny) || isVisited[nx][ny]) continue;
                if(ppuyo[nx][ny] != c) continue;

                isVisited[nx][ny] = true;
                q.add(new Pair(nx,ny));
                qq.add(new Pair(nx,ny));
            }
        }

        if(qq.size() >= 4){
            while(!qq.isEmpty()){
                Pair p = qq.poll();
                ppuyo[p.x][p.y] = '.';
            }
            return true;
        }

        return false;
    }

    static boolean OOB(int x, int y){
        return x < 0 || y < 0 || x >=12 || y>=6;
    }

    static void down(){
        for(int i=0; i<6; i++){
            int idx = 11;
            for(int j=11; j>=0; j--){
                if(ppuyo[j][i] != '.') {
                    ppuyo[idx--][i] = ppuyo[j][i];                    
                }
            }
            for(int j=idx; j>=0; j--){
                ppuyo[j][i] = '.';
            }
        }
    }

    static void print(){
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                System.out.print(ppuyo[i][j]);
            }
            System.out.println();
        }
    }
    
}
