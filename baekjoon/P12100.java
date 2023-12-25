import java.util.*;

public class P12100 {
    static char[] chars = {'u','d','r','l'};
    static char[] moves = new char[5];
    static int N;
    static int[][] board;
    static int[][] copyBoard;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];
        copyBoard = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = sc.nextInt();
            }
        }

        sc.close();
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth){
        if(depth == 5){
            copy();
            for(char c : moves){
                move(c);
            }

            return;
        }

        for(int i=0; i<4; i++){
            moves[depth] = chars[i];
            dfs(depth+1);

        }

    }

    static void move(char direction){

        if(direction == 'u'){

            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();

                for(int j=0; j<N; j++){                    
                    if(copyBoard[j][i] != 0){
                        sb.append((char)(copyBoard[j][i] + '0'));
                    }
                    copyBoard[j][i] = 0;
                }
                
                String s = sb.toString();
                int index = 0;
                for(int k=0; k<s.length(); k++){
                    char c = s.charAt(k);
                    int n = c - '0';
                    
                    if(k + 1 < s.length() && c == s.charAt(k+1)){
                        n = (c - '0') * 2;
                        k++;
                    }
                    copyBoard[index++][i] = n;

                    result = Math.max(result,n);
                }
            }
        }else if(direction == 'd'){
            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();

                for(int j=N-1; j>=0; j--){                    
                    if(copyBoard[j][i] != 0){
                        sb.append((char)(copyBoard[j][i] + '0'));
                    }
                    copyBoard[j][i] = 0;
                }
                
                String s = sb.toString();
                
                int index = N-1;
                for(int k=0; k<s.length(); k++){
                    char c = s.charAt(k);
                    int n = c - '0';
                    if(k + 1 < s.length() && c == s.charAt(k+1)){
                        n = (c - '0') * 2;
                        k++;
                    }
                    copyBoard[index--][i] = n;
                    result = Math.max(result,n);
                }
            }
        }else if(direction =='r'){
            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();

                for(int j=N-1; j>=0; j--){                    
                    if(copyBoard[i][j] != 0){
                        sb.append((char)(copyBoard[i][j] + '0'));
                    }
                    copyBoard[i][j] = 0;
                }
                
                String s = sb.toString();
                
                int index = N-1;
                for(int k=0; k<s.length(); k++){
                    char c = s.charAt(k);
                    int n = c - '0';
                    if(k + 1 < s.length() && c == s.charAt(k+1)){
                        n = (c - '0') * 2;
                        k++;
                    }
                    copyBoard[i][index--] = n;
                    result = Math.max(result,n);
                }
            }

        }else if(direction =='l'){
            for(int i=0; i<N; i++){
                StringBuilder sb = new StringBuilder();

                for(int j=0; j<N; j++){                    
                    if(copyBoard[i][j] != 0){
                        sb.append((char)(copyBoard[i][j] + '0'));
                    }
                    copyBoard[i][j] = 0;
                }
                
                String s = sb.toString();
                
                int index = 0;
                for(int k=0; k<s.length(); k++){
                    char c = s.charAt(k);
                    int n = c - '0';
                    if(k + 1 < s.length() && c == s.charAt(k+1)){
                        n = (c - '0') * 2;
                        k++;
                    }
                    copyBoard[i][index++] = n;
                    result = Math.max(result,n);
                }
            }
        }
    }

    static void copy(){
        for(int i=0; i<N; i++){
            copyBoard[i] = board[i].clone();
        }
    }
    
    
    
}
