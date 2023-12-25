import java.util.*;

public class P14499 {
    // 0
    //123
    // 4
    // 5
    static int[] dice = new int[6];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int[][] map;

    static int x,y;
    static int N,M;

    public static void main(String[] args){
        int K;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        K = sc.nextInt();
        
        map = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<K; i++){
            int move = sc.nextInt();
            move(move);                            
        }

        sc.close();


    }

    static void move(int dir){
        // right, left, top, bottom
        int d = dir - 1;

        int nx = x + dx[d];
        int ny = y + dy[d];

        if(OOB(nx,ny)) return;

        rotate(dir);

        x = nx;
        y = ny;

        if(map[x][y] != 0){
            dice[5] = map[x][y];
            map[x][y] = 0;
        }else{
            map[x][y] = dice[5];
        }

        System.out.println(dice[2]);
    }

    static boolean OOB(int x, int y){
        return x >= N || y >= M || x < 0 || y < 0;
    }

    static void rotate(int dir){
        if(dir == 1){
            int temp = dice[5];
            dice[5] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = temp;
        }else if(dir==2){
            int temp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = dice[5];
            dice[5] = temp;
        }else if(dir == 3){
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[4];
            dice[4] = dice[5];
            dice[5] = temp;
        }else if (dir == 4){
            int temp = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[2];
            dice[2] = dice[0];
            dice[0] = temp;
        }
    }
    
}
