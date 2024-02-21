import java.util.*;
import java.io.*;

public class P1197 {
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int cost;

        Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        parent = new int[V+1];

        for(int i=0; i<V+1; i++){
            parent[i] = i;
        }

        int E = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s,e,cost));
        }

        Collections.sort(edges);
        // edges.forEach(e-> System.out.println(e.cost));

        int result = 0;
        for(Edge e : edges){
            if(find(e.s) == find(e.e)) continue;
            union(e.s, e.e);
            result += e.cost;
        }

        System.out.println(result);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            return find(parent[x]);
        }
    }
    
}
