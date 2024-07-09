import java.util.*;
import java.io.*;

public class P2606 {
    static List<Integer>[] graph;
    static boolean[] isVisited;
    static int ret = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            String s = br.readLine();
            String[] splitedS = s.split(" ");

            int v = Integer.parseInt(splitedS[0]);
            int u = Integer.parseInt(splitedS[1]);

            graph[v].add(u);
            graph[u].add(v);
        }
        
        isVisited[1] = true;
        bfs(1);
    

        bw.write(ret + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int start){
        
        List<Integer> list = graph[start];
        for(int u : list){
            if(isVisited[u]) continue;
            isVisited[u] = true;
            ret++;
            bfs(u);
        }
    }
}
