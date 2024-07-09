import java.util.*;
import java.io.*;

public class P16236 {

    static int N;
    static int[][] map;
    static int sharkX, sharkY;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int size = 2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            String[] numbers = s.split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(numbers[j]);
                if(map[i][j] == 9){
                    map[i][j] = 0;
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        
        
        int answer = solve();

        bw.write(answer + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    static int solve(){
        int ret = 0;

        int cnt = 0;
        while(true){
            
            int second = bfs();

            // printMap();

            if(second == 0){
                break;
            }else{
                cnt++;
                if(cnt == size){
                    size++;
                    cnt = 0;
                }
                ret+=second;
            }
        }

        return ret;
    }

    static int bfs(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> 
            x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]
        );

        Queue<int[]> q = new LinkedList<>();

        boolean[][] isVisited = new boolean[N][N];
        q.add(new int[]{sharkX, sharkY, 0});
        isVisited[sharkX][sharkY] = true;
        
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] shark = q.poll();

            int x = shark[0];
            int y = shark[1];
            int second = shark[2];
            if(map[x][y] != 0 && size > map[x][y] && second <= min){
                min = second;
                pq.add(new int[]{x,y});
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(OOB(nx,ny) || isVisited[nx][ny] || size < map[nx][ny]) continue;
                isVisited[nx][ny] = true;
                q.add(new int[]{nx,ny,second+1});
            }
        }

        if(!pq.isEmpty()){
            int[] shark = pq.poll();
            
            int x =shark[0];
            int y = shark[1];
            map[x][y] = 0;
            sharkX = x;
            sharkY = y;
            return min;
        }
        

        return 0;
    }

    static boolean OOB(int x, int y){
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    static void printMap(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
    }
}
