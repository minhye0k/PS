import java.io.*;
import java.util.*;

public class tsp1 {
    static boolean isVisited[];
    static double dist[][];
    static int N;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            N = Integer.parseInt(br.readLine());

            isVisited = new boolean[N];
            dist = new double[N][N];

            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<N; j++){
                    dist[i][j] = Double.parseDouble(st.nextToken());
                }
            }

            double cost = Double.MAX_VALUE;
            for(int i=0; i<N; i++){
                isVisited[i] = true;
                cost = Math.min(cost ,(Math.floor(travel(i, 1, 0) * 10000000000L)) / 10000000000.0);

                isVisited[i] = false;
            }
            bw.write(cost + "\n");
        }

        bw.close();
        br.close();
    }

    static double travel(int vertex, int cnt, double cost){
        if(cnt == N) return cost;
        
        double ret = Double.MAX_VALUE;

        for(int i=0; i<N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                ret = Math.min(ret, travel(i, cnt+1, cost + dist[vertex][i]));
                isVisited[i] = false;
            }
        }

        return ret;
    }
    
}
