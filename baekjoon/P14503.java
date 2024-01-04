import java.util.*;

public class P14503 {
    // top, right, bottom, left
    // 0, 1, 2, 3
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N,M;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int r, c, d;

        int result = 0;

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        int[][] room = new int[N][M];
        boolean[][] isCleaned = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                room[i][j] = sc.nextInt();
            }
        }

        sc.close();

        while(true){
            if(!isCleaned[r][c]) {
                isCleaned[r][c] = true;
                result++;
            }

            boolean moved = false;

            for(int i=1; i<5; i++){
                int nd = d - i;
                if(nd<0){
                    nd+=4;
                }
                int nr = r + dx[nd];
                int nc = c + dy[nd];

                if(OOB(nr,nc) || isCleaned[nr][nc] || room[nr][nc] == 1) continue;

                moved = true;
                d = nd;
                r = nr;
                c = nc;
                break;
            }

            if(moved) continue;

            int nd;
            if(d==0){
                nd = 2;
            }else if(d==1){
                nd = 3;
            }else if(d==2){
                nd = 0;
            }else{
                nd = 1;
            }

            int nr = r + dx[nd];
            int nc = c + dy[nd];

            if(OOB(nr,nc) || room[nr][nc] == 1) break;

            r = nr;
            c = nc;
        }

        System.out.println(result);

    }

    static boolean OOB(int x, int y){
        return x<0 || y<0 || x >=N || y>=M;
    }
}
