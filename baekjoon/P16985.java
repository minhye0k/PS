import java.util.*;

public class P16985 {
    static int[][][] miro = new int[5][5][5];
    static boolean[][][] isVisited = new boolean[5][5][5];
    static int[][][] miroCopy = new int[5][5][5];

    static boolean[] miroVisited = new boolean[5];

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] dz = {1,-1};

    static int result = Integer.MAX_VALUE;
    static Point[][] fromTo = new Point[5][2];

    static int[] dir = new int[5];

    static class Point{
        int z;
        int x;
        int y;
        int cnt;

        Point(int z,int x, int y, int cnt){
            this.z = z;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        boolean equals(Point p){
            return p.z == z && p.y == y && p.x == x;
        }

        boolean valid(){
            return miroCopy[z][x][y] == 1;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    miro[i][j][k] = sc.nextInt();
                }
            }
        }

        sc.close();

        fromTo[0][0] = new Point(0,0,0,0);
        fromTo[0][1] = new Point(4,4,4,0);

        fromTo[1][0] = new Point(0,4,0,0);
        fromTo[1][1] = new Point(4,0,4,0);

        fromTo[2][0] = new Point(0,0,4,0);
        fromTo[2][1] = new Point(4,4,0,0);

        fromTo[3][0] = new Point(0,4,4,0);
        fromTo[3][1] = new Point(4,0,0,0);

        dfs(0);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    static void dfs(int depth){
        if(depth == 5){
            dfs2(0);
            return;
        }

        for(int i=0; i<5; i++){
            if(miroVisited[i]) continue;
            miroVisited[i] = true;
            miroCopy(i,depth);
            dfs(depth+1);
            miroVisited[i] = false;
        }
        
    }

    static void miroCopy(int from, int to){
        for(int i=0; i<5; i++){
            miroCopy[to][i] = miro[from][i].clone();
        }
    }

    static void dfs2(int depth){
        if(depth == 5){
            for(int i=0; i<5; i++){
                miroCopy[i] = rotate(miroCopy[i], dir[i]);
            }

            for(int i=0; i<4; i++){
                Point start = fromTo[i][0];
                Point end = fromTo[i][1];

                if(!start.valid() || !end.valid()) continue;
                bfs(fromTo[i][0], fromTo[i][1]);
            }

            return;
        }

        for(int i=0; i<4; i++){
            dir[depth] = i;
            dfs2(depth+1);
        }
    }

    static int[][] rotate(int[][] target, int n){
        if(n == 0) return target;

        if(n==1) return rotate90(target);
        if(n==2) return rotate180(target);
        else return rotate270(target);
        
    }

    static int[][] rotate90(int[][] target){
        int[][] ret = new int[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                ret[j][5-i-1] = target[i][j];
            }
        }

        return ret;
    }

    static int[][] rotate180(int[][] target){
        int[][] ret = new int[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                ret[5-i-1][5-j-1] = target[i][j];
            }
        }

        return ret;
    }

    static int[][] rotate270(int[][] target){
        int[][] ret = new int[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                ret[5-j-1][i] = target[i][j];
            }
        }

        return ret;
    }

    static void bfs(Point start, Point end){

        Queue<Point> q = new LinkedList<>();
        isVisited = new boolean[5][5][5];
        isVisited[start.z][start.x][start.y] = true;
        q.add(start);

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.equals(end)){
                result = Math.min(result,p.cnt);
                return;
            }

            int z = p.z;
            int x = p.x;
            int y = p.y;

            for(int i=0; i<2; i++){
                int nz = z + dz[i];
                if(OOB(nz, x, y) || isVisited[nz][x][y] || miroCopy[nz][x][y] == 0) continue;            
                q.add(new Point(nz, x, y, p.cnt+1));
                isVisited[nz][x][y] = true;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(OOB(z, nx, ny) || isVisited[z][nx][ny] || miroCopy[z][nx][ny] == 0) continue;
                
                q.add(new Point(z, nx, ny, p.cnt+1));
                isVisited[z][nx][ny] = true;
            }

        }

    }

    static boolean OOB(int z, int x, int y){
        return z<0 || x<0 || y<0 || z>=5 || x>=5 || y>=5;
    }
}
