import java.util.*;
import java.io.*;

public class P5567 {
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
            String[] vertexes = s.split(" ");

            int u = Integer.parseInt(vertexes[0]);
            int v = Integer.parseInt(vertexes[1]);

            graph[u].add(v);
            graph[v].add(u);
        }
        
        bfs();

        bw.write(ret + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        isVisited[1] = true;
        q.add(new int[]{1,0});
        
        
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int start = pair[0];
            int depth = pair[1];
            List<Integer> list = graph[start];

            if(depth >= 2) continue;

            for(int u : list){
                if(isVisited[u]) continue;
                isVisited[u] = true;
                ret++;
                q.add(new int[]{u,depth+1});
            }
        }
        
    }
}
