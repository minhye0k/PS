import java.io.*;
import java.util.*;

public class picnic {
    static boolean areFriends[][];
    static boolean isChosen[];
    static int answer = 0;
    static int n = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            String input[] = br.readLine().split(" ");

            n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            areFriends = new boolean[n][n];
            isChosen = new boolean[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<m; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                areFriends[a][b] = true;
                areFriends[b][a] = true;
            }

            answer = countParings();
            bw.write(answer +"\n");
            bw.flush(); 
        }

        br.close();
        bw.close();
    }

    static int countParings(){
        int first = -1;
        
        for(int i=0; i<n; i++){
            if(!isChosen[i]){
                first = i;
                break;
            }
        }

        if(first == -1) return 1;

        int ret = 0;

        for(int i=first+1; i<n; i++){
            if(!isChosen[i] && areFriends[first][i]){
                isChosen[first] = isChosen[i] = true;
                ret += countParings();
                isChosen[first] = isChosen[i] = false;
            }
        }

        return ret;
    }



    
}
