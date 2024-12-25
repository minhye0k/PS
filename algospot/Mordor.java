import java.io.*;

public class Mordor {

    static int[] max;
    static int[] min;
    static int N, Q;
    static int[] h;
    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            Q = Integer.parseInt(input[1]);

            h = new int[N];
            input = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                h[i] = Integer.parseInt(input[i]);
            }

            init();

            for(int i=0; i<Q; i++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                int mini = query(a, b, true);
                int maxi = query(a, b, false);

                int answer = maxi - mini;
                bw.write(answer + "\n");
                bw.flush();
            }
        }


        br.close();
        bw.close();
    }

    static void init() {
        max = new int[4*N];
        min = new int[4*N];

        min[1] = initMin(0, N-1, 1);
        max[1] = initMax(0, N-1, 1);
    }

    static int initMin(int left, int right, int node){
        if(left == right) return min[node] = h[left];

        int mid = (left + right) / 2;
        int leftMin = initMin(left, mid, node * 2);
        int rightMin = initMin(mid+1, right, node * 2 + 1);

        return min[node] = Math.min(leftMin, rightMin);
    }

    static int initMax(int left, int right, int node){
        if(left == right) return max[node] = h[left];

        int mid = (left + right) / 2;
        int leftMax = initMax(left, mid, node * 2);
        int rightMax = initMax(mid+1, right, node * 2 + 1);

        return max[node] = Math.max(leftMax, rightMax);
    }

    static int query(int left,
                     int right,
                     int node,
                     int nodeLeft, 
                     int nodeRight,
                     boolean isMin) {
        if(left > nodeRight || right < nodeLeft) return isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        
        if(left <= nodeLeft && nodeRight <= right) return isMin ? min[node] : max[node];

        int mid = (nodeLeft + nodeRight) / 2;

        return isMin ? Math.min(query(left, right, node*2, nodeLeft, mid, isMin), query(left, right, node*2+1, mid+1, nodeRight, isMin)) :
                Math.max(query(left, right, node*2, nodeLeft, mid, isMin), query(left, right, node*2+1, mid+1, nodeRight, isMin));
    }

    static int query(int left, int right, boolean isMin){
        return query(left, right, 1, 0, N-1, isMin);
    }
    
}
