import java.util.*;

public class P15683 {

    static int N, M;
    static int[][] area;
    static int[] di = new int[8];
    static List<Cctv> cctvs = new ArrayList<>();

    static int[][] areaCopy;

    static int result = Integer.MAX_VALUE;

    // right, down, left, up
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Cctv{
        int num;
        int x;
        int y;

        Cctv(int num, int x,int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int depth){
        if(cctvs.size() == depth){
            copy();

            for(int i=0; i<depth; i++) {
                watch(cctvs.get(i), i);
            }
            result = Math.min(result, countBlindSpot());
            return;
        }

        for(int i=0; i<4; i++){
            di[depth] = i;
            dfs(depth+1);
        }
    }

    // right, down, left, up
    static void watch(Cctv cctv, int index){
        int num = cctv.num;
        int dir = di[index];
        if(num == 1){
            check(cctv, dir);
        }else if(num == 2){
            if(dir == 0 || dir == 2){
                check(cctv, 0);
                check(cctv, 2);
            }else{
                check(cctv,1);
                check(cctv,3);
            }
        }else if(num == 3){
            if(dir == 0){
                check(cctv,3);
                check(cctv,0);
            }else if(dir == 1){
                check(cctv, 0);
                check(cctv,1);
            }else if(dir == 2){
                check(cctv,2);
                check(cctv,1);
            }else{
                check(cctv,3);
                check(cctv,2);
            }
        }else if(num == 4){
            for(int i=0; i<4; i++){
                if(dir == i) continue;
                check(cctv,i);
            }
        }else{
            for(int i=0; i<4; i++){
                check(cctv,i);
            }
        }
    }

    static void check(Cctv cctv, int direction){
        int x = cctv.x;
        int y = cctv.y;

        while(true){
            x += dx[direction];
            y += dy[direction];

            if(OOB(x,y) || areaCopy[x][y] == 6) return;
            areaCopy[x][y] = -1;
        }
    }

    static boolean OOB(int x, int y){
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    static void copy(){
        for(int i=0; i<N; i++){
            areaCopy[i] = area[i].clone();
        }
    }

    static int countBlindSpot(){
        int ret = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(areaCopy[i][j] == 0) ret++;
            }
        }

        return ret;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        area = new int[N][M];
        areaCopy = new int[N][M];


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                area[i][j] = sc.nextInt();
                if(1 <= area[i][j] && area[i][j] <= 5) {
                    cctvs.add(new Cctv(area[i][j], i, j));
                }
            }
        }

        dfs(0);

        System.out.println(result);

        sc.close();
    }
    
}
