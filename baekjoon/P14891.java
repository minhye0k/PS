import java.util.*;

public class P14891 {
    static int[][] gears = new int[4][8];
    static final int RIGHT = 2;
    static final int LEFT = 6;

    static final int N = 0;
    static final int S = 1;

    static boolean[] isVisited = new boolean[4];
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<4; i++){
            String s = sc.nextLine();
            for(int j=0; j<8; j++){
                gears[i][j] = s.charAt(j) - '0';
            }
        }


        int K = sc.nextInt();
        for(int i=0; i<K; i++){
            isVisited = new boolean[4];

            int n = sc.nextInt() - 1;
            int dir = sc.nextInt();

            
            solve(n,dir);
        }


        sc.close();

        int result = 0;

        int score = 1;
        for(int i=0; i<4; i++){
            if(gears[i][0] == S){
                result += score;
            }

            score *= 2;
        }

        System.out.println(result);


    }

    static void solve(int start, int dir){
        
        int left = gears[start][LEFT];
        int right = gears[start][RIGHT];
        
        rotate(start, dir);
        isVisited[start] = true;

        if(start != 0 && !isVisited[start-1]){
            if(gears[start - 1][RIGHT] != left){
                solve(start-1, -1 * dir);
            }
        }

        if(start != 3 && !isVisited[start+1]){
            if(gears[start+1][LEFT] != right){
                solve(start+1, -1 * dir);
            }
        }
    }

    static void rotate(int n, int dir){
        if(dir == 1){
            int temp = gears[n][7];
            for(int i=7; i>=1; i--){
                gears[n][i] = gears[n][i-1];
            }
            gears[n][0] = temp;
        }else if(dir==-1){
            int temp = gears[n][0];
            for(int i=0; i<7; i++){
                gears[n][i] = gears[n][i+1];
            }
            gears[n][7] = temp;
        }
    }

    static void print(){
        for(int i=0; i<8; i++){
            for(int j=0; j<4; j++){
                System.out.print(gears[j][i]);
            }
            System.out.println();
        }
    }
}
