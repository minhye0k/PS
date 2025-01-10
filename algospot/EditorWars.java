import java.util.*;

public class EditorWars {
    static final String ACK = "ACK";
    static final String DIS = "DIS";

    static int[] size;
    static int[] rank;
    static int[] parent;
    static int[] enemy;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while (C-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            parent = new int[N];
            rank = new int[N];
            size = new int[N];
            enemy = new int[N];

            for(int i=0; i<N; i++) {
                parent[i] = i;
                size[i] = 1;
                enemy[i] = -1;
            }

            sc.nextLine();

            boolean isContradiction = false;
            boolean hasDis = false;
            boolean hasAck = false;

            int contradictionIdx = 0;

            for(int i=0; i<M; i++) {
                String input[] = sc.nextLine().split(" ");
                String command = input[0];

                int u = Integer.parseInt(input[1]);
                int v = Integer.parseInt(input[2]);

                if(isContradiction) continue;

                if(command.equals(ACK)){
                    hasAck = true;
                    if(!ack(u, v)) {
                        isContradiction = true;
                        contradictionIdx = i+1;
                    }
                }else{
                    hasDis = true;
                    if(!dis(u, v)) {
                        isContradiction = true;
                        contradictionIdx = i+1;
                    }
                }
            }

            if(!isContradiction) {
                System.out.println("MAX PARTY SIZE IS " + answer(N));
            }else{
                System.out.println("CONTRADICTION AT " + (contradictionIdx));
            }
        }

        sc.close();
    }

    static int union(int u, int v){
        if(u==-1 || v==-1) return Math.max(u,v);
        u = find(u); v = find(v);

        if(u==v) return v;

        if(rank[u] < rank[v]){
            int tmp = u;
            u = v;
            v = tmp;
        }
        if(rank[u] == rank[v]) rank[u]++;

        size[u] += size[v];
        parent[v] = u;

        return u;
    }

    static int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }

    static boolean ack(int u, int v){
        u = find(u); v = find(v);

        if(enemy[u] == v) return false;

        int a = union(u, v); int b = union(enemy[u], enemy[v]);

        if(b != -1) enemy[b] = a;
        enemy[a] = b;
        return true;
    }

    static boolean dis(int u, int v){
        u = find(u); v = find(v);
        if(u == v) return false;

        int a = union(u, enemy[v]); int b = union(v, enemy[u]);

        enemy[a] = b; enemy[b] = a;
        return true;
    }

    static int answer(int N){
        int ret = 0;

        for(int i = 0; i<N; i++){
            if(parent[i] == i){
                int enem = enemy[i];
                if(enem > i) continue;
                int mySize = size[i];
                int enemySize = enem == -1 ? 0 : size[enem];

                ret += Math.max(mySize, enemySize);
            }
        }

        return ret;
    }

}
