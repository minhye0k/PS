import java.util.*;
import java.io.*;

public class P14889 {
    static int N;
    static int[][] S;
    static boolean[] isVisited;
    
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        isVisited = new boolean[N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            String[] numbers = s.split(" ");
            for(int j=0; j<N; j++){
                int value = Integer.parseInt(numbers[j]);
                S[i][j] = value;
            }
        }

        dfs(0, 0);
        bw.write(answer + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }

    static void dfs(int cnt, int idx){
        if(cnt == N/2){
            List<Integer> teamA = new ArrayList<>();
            List<Integer> teamB = new ArrayList<>();

            for(int i=0; i<N; i++){
                if(isVisited[i]) {
                    teamA.add(i);
                }
                else teamB.add(i);
            }

            int teamAValue = getValue(teamA);
            int teamBValue = getValue(teamB);
            int diff = Math.abs(teamAValue - teamBValue);

            answer = Math.min(diff,answer);

            return;
        }
        
        for(int i=idx; i<N; i++){
            if(isVisited[i]) continue;

            isVisited[i] = true;
            dfs(cnt+1, i);
            isVisited[i] = false;
        }
    }

    static int getValue(List<Integer> team){
        int ret = 0;

        for(int i=0; i<team.size(); i++){
            for(int j=0; j<team.size(); j++){
                if(i==j) continue;
                int personA = team.get(i);
                int personB = team.get(j);

                ret += S[personA][personB];
            }
        }

        return ret;
    }


}
