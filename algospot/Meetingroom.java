import java.util.*;

public class Meetingroom {
    static class Pair implements Comparable<Pair>{
        int a;
        int b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair pair){
            if(this.a == pair.a){
                return this.b - pair.b;
            }
            return this.a - pair.a;
        }

    }

    static int[][] adj;
    static Pair[] meetings;
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();
            
            meetings = new Pair[n*2];
            for(int i=0; i<n*2; i+=2){
                meetings[i] = new Pair(sc.nextInt(), sc.nextInt());
                meetings[i+1] = new Pair(sc.nextInt(), sc.nextInt());
            }
            
            makeGraph();
            int[] result = solve2SAT();

            if(result.length == 0){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println("POSSIBLE");
                for(int i=0; i<result.length; i++){
                    if(result[i] == 1){
                        System.out.println(meetings[i].a + " " + meetings[i].b);
                    }
                }
            }
        }

        sc.close();
    }

    static void makeGraph(){
        int vars = meetings.length;
        adj = new int[vars*2][vars*2];

        for(int i=0; i<vars; i+=2){
            int j = i+1;
            adj[i*2][j*2+1] = 1;
            adj[j*2][i*2+1] = 1;
        }

        for(int i=0; i<vars; i+=2){
            int j = i+1;
            adj[i*2+1][j*2] = 1;
            adj[j*2+1][i*2] = 1;
        }

        for(int i=0; i<vars; i++){
            for(int j=0; j<i; j++){
                if(!disjoint(meetings[i],meetings[j])){
                    adj[i*2][j*2+1] = 1;
                    adj[j*2][i*2+1] = 1;
                }
            }
        }
    }

    static boolean disjoint(Pair p1, Pair p2){
        return p2.a >= p1.b || p1.a >= p2.b;
    }

    static int[] solve2SAT(){
        int meetingCount = n*2;
        int[] label = tarjanSCC();

        for(int i=0; i<meetingCount; i+=2){
            if(label[i] == label[i+1]) return new int[]{};
        }

        int[] result = new int[meetingCount];
        Arrays.fill(result, -1);

        Pair[] order = new Pair[meetingCount*2];

        for(int i=0; i<meetingCount*2; i++){
            order[i] = new Pair(-label[i], i);
        }

        Arrays.sort(order);

        for(int i=0; i<order.length; i++){
            int vertex = order[i].b;

            int variable = vertex/2, isTrue = vertex % 2 == 0 ? 1 : 0;

            if(result[variable] != -1) continue;

            result[variable] = isTrue == 1 ? 0 : 1;
        }

        return result;
    }

    static int[] sccId;
    static int[] discovered;
    static Stack<Integer> st;
    static int sccCounter, vertexCounter;

    static int[] tarjanSCC(){
        st = new Stack<>();
        discovered = new int[adj.length];
        Arrays.fill(discovered, -1);
        sccId = new int[adj.length];
        Arrays.fill(sccId, -1);

        sccCounter = vertexCounter = 0;

        for(int i=0; i<adj.length; i++){
            if(discovered[i] == -1) scc(i);
        }


        return sccId;
    }

    static int scc(int v){
        int ret = discovered[v] = vertexCounter++;
        st.push(v);

        for(int there=0; there<adj.length; there++){
            if(adj[v][there] == 0) continue;

            if(discovered[there] == -1){
                ret = Math.min(ret, scc(there));
            }else if(sccId[there] == -1){
                ret = Math.min(ret, discovered[there]);
            }
        }

        if(ret == discovered[v]){
            while(true){
                int t = st.pop();
                sccId[t] = sccCounter;
                if(t == v) break;
            }
            sccCounter++;
        }
        return ret;
    }
    
}
