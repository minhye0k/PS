import java.util.*;
import java.io.*;

public class FamilyTree {
    static List<List<Integer>> childs;
    static int[] locInTrip;
    static int[] serialToNo;
    static int[] noToSerial;
    static int[] depth;
    static RMQ rmq;
    

    static class RMQ {
        static int serialNo;
        int tree[];
        int N;

        RMQ(List<Integer> trip){
            tree = new int[trip.size() * 4];
            N = trip.size();

            init(1, 0, N-1, trip);
        }

        int init(int node, int left, int right, List<Integer> trip) {
            if(left == right) return tree[node] = trip.get(left);

            int mid = (left+right) / 2;

            return tree[node] = Math.min(init(node*2, left, mid, trip),init(node*2+1,mid+1, right, trip));
        }

        int query(int left, int right){
            return query(left, right, 1, 0, N-1);
        }

        int query(int left, int right, int node, int nodeLeft, int nodeRight){
            if(left > nodeRight || right < nodeLeft) return Integer.MAX_VALUE;

            if(left <= nodeLeft && nodeRight <= right) return tree[node];

            int mid = (nodeLeft + nodeRight) / 2;
            return Math.min(query(left, right, node*2, nodeLeft, mid), query(left, right, node*2+1, mid+1, nodeRight));
        }

        static RMQ prepare(){
            serialNo = 0;
            List<Integer> trip = new ArrayList<>();
            traverse(0,0,trip);
            // print(trip);
            return new RMQ(trip);
        }

        static void traverse(int here, int d, List<Integer> trip){
            noToSerial[here] = serialNo;
            serialToNo[serialNo] = here;

            serialNo++;

            locInTrip[here] = trip.size();
            trip.add(noToSerial[here]);

            depth[here] = d;
            List<Integer> child = childs.get(here);

            for(int i=0; i < child.size(); i++) {
                traverse(child.get(i), d+1, trip);
                trip.add(noToSerial[here]);
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int Q = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            childs = new ArrayList<>();
            for(int i=0; i<N; i++){
                childs.add(new ArrayList<>());
            }

            serialToNo = new int[2*N+1];
            noToSerial = new int[N];
            depth = new int[N];
            locInTrip = new int[N];

            for(int i=0; i<input.length; i++) {
                int daddy = Integer.parseInt(input[i]);
                childs.get(daddy).add(i+1);
            }

            rmq = RMQ.prepare();
            for(int i=0; i<Q; i++){
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                
                int answer = distance(rmq, u, v);
                bw.write(answer + "\n");
                bw.flush();
            }

        }

        br.close();
        bw.close();
    }

    static int distance(RMQ rmq, int u, int v){
        int lu = locInTrip[u];
        int lv = locInTrip[v];

        if(lu > lv){
            int tmp = lu;
            lu = lv;
            lv = tmp;
        }

        int lca = serialToNo[rmq.query(lu, lv)];
        return depth[u] + depth[v] - depth[lca]*2;
    }

    static void print(List<Integer> trip){
        for(int i=0; i<trip.size(); i++){
            System.out.print(trip.get(i) + " ");
        }
        System.out.println();
    }

    
}
