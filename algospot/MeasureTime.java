import java.io.*;

public class MeasureTime {
    static class FenwickTree{
        int[] tree = new int[1000001];

        long sum(int pos){
            pos++;

            int ret = 0;
            while(pos > 0){
                ret += tree[pos];
                pos &= (pos-1);
            }

            return ret;
        }

        void add(int pos, int value){
            pos++;

            while(pos < tree.length){
                tree[pos] += value;
                pos += (pos & -pos);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            int N = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");
            FenwickTree fenwick = new FenwickTree();
            
            long ret = 0;
            for(int i=0; i<N; i++){
                int A = Integer.parseInt(input[i]);

                ret += fenwick.sum(999999) - fenwick.sum(A);
                fenwick.add(A, 1);

            }

            bw.write(ret + "\n");
            bw.flush();
        }


        br.close();
        bw.close();
    }


}
