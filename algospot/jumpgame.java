import java.io.*;
import java.util.*;

public class jumpgame {
    static int N;
    static int[][] board;
    static int[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            cache = new int[N][N];

            for(int i=0; i<N; i++){
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);

                for(int j=0; j<N; j++){
                    int num = Integer.parseInt(st.nextToken());
                    board[i][j] = num;
                    cache[i][j] = -1;
                }
            }

            int isReached = jump(0, 0);
            // System.out.println((isReached == 1)? "YES" : "NO");
            bw.write((isReached == 1)? "YES" : "NO" + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    static int jump(int x, int y){
        if(x >= N || y >= N) return 0;
        if(x == N-1 && y == N-1) return 1;

        if(cache[x][y] != -1){
            return cache[x][y];
        }

        int dist = board[x][y];
        
        return cache[x][y] = jump(x + dist, y) | jump(x, y + dist);


    }
    
}
