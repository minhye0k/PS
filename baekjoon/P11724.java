import java.util.*;
import java.io.*;

public class P11724 {
    static List<Integer>[] graph;
    static boolean isVisited[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        int count = 0;
        for(int i=1; i<=N; i++){
            if(isVisited[i]) continue;
            dfs(i);
            count++;
        }

        bw.write(count + "\n");
        bw.flush();
    }

    public static void dfs(int s){
        isVisited[s] = true;

        int size = graph[s].size();
        for(int i=0; i<size; i++){
            int next = graph[s].get(i);
            if(!isVisited[next]) dfs(next);
        }
    }
}
