import java.io.*;
import java.util.StringTokenizer;

public class boardcover {
    static int board[][];
    static int H;
    static int W;

    static int[][][] cover = {
        {{0,0}, {0,1}, {1,0}},
        {{0,0}, {0,1}, {1,1}},
        {{0,0}, {1,0}, {1,1}},
        {{0,0}, {1,0}, {1,-1}}
    };


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new int[H][W];

            int blockedCount = 0;

            for(int i=0; i<H; i++){
                String s = br.readLine();
                
                for(int j=0; j<W; j++){
                    char c = s.charAt(j);
                    if(c == '#'){
                        board[i][j] = 1;
                        blockedCount++;
                    }
                }
            }
            
            int emptyCount = H*W - blockedCount;
            if(emptyCount % 3 != 0) bw.write(0 + "\n");
            else bw.write(countingFilled() + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    static int countingFilled(){
        int x = -1, y = -1;

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(board[i][j] == 0){
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1) break;
        }

        if(x == -1) return 1;
        int ret = 0;
        
        for(int i=0; i<4; i++){
            if(set(x, y, i, true)){
                ret += countingFilled();
            }
            set(x,y,i,false);
        }        
        

        return ret;
    }

    static boolean set(int x, int y, int type, boolean fill){
        boolean isPossible = true;

        for(int i=0; i<3; i++){
            int nx = x + cover[type][i][0];
            int ny = y + cover[type][i][1];

            if(OOB(nx,ny)) isPossible = false;
            else if((board[nx][ny] += (fill ? 1 : -1)) > 1) isPossible = false;   
        }

        return isPossible;
    }

    static boolean OOB(int x, int y){
        return x < 0 || x >= H || y <0 || y >= W;
    }


    
}
