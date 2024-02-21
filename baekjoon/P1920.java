import java.util.*;
import java.io.*;

public class P1920 {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());

            boolean exists = exists(num);
            bw.write((exists ? 1 : 0) + "\n");
        }

        bw.flush();
    }

    public static boolean exists(int num){
        boolean ret = false;

        int start = -1;
        int end = N;

        while(start+1 < end){
            int mid = (start + end) / 2;
            // System.out.println(mid);

            int n = arr[mid];
            if(n>num){
                end = mid;
            }else if(n<num){
                start = mid;
            }else if(n==num){
                return true;
            }
        }

        return ret;
    }
}
