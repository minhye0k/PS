import java.util.*;
import java.io.*;

public class P1260 {
    static List<Integer>[] graph;
    static boolean[] isVisited;
    static StringBuilder sb;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for(int i=0; i<=N; i++){
            Collections.sort(graph[i]);
        }   

        
        sb = new StringBuilder();
        isVisited = new boolean[N+1];
        dfs(V);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        isVisited = new boolean[N+1];
        bfs(V);
        System.out.println(sb.toString());
    }

    static void dfs(int n){
        isVisited[n] = true;
        sb.append(n + " ");

        for(int i=0; i<graph[n].size(); i++){
            int num = graph[n].get(i);
            if(isVisited[num]) continue;
            dfs(num);
        }
    }

    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        isVisited[n] = true;

        while(!q.isEmpty()){
            int num = q.poll();

            sb.append(num + " ");
            for(int i=0; i<graph[num].size(); i++){
                int cur = graph[num].get(i);
                if(isVisited[cur]) continue;
                q.add(cur);
                isVisited[cur] = true;
            }

        }
    }
}
