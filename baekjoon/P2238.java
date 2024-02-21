import java.io.*;
import java.util.*;

public class P2238 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s]++;
            arr[e]--;

        }

        int[] sums = new int[1000001];
        sums[0] = arr[0];
        for(int i=1; i<1000001; i++){
            sums[i] = sums[i-1] + arr[i];
        }

        int start = 0, end = 0;
        int sum = 0;

        boolean isSolved = false;
        while(true){
;
            if(sum==K){
                isSolved=true;
                break;
            }
            if(sum>K){
                sum -= sums[start++];
            }else if(end > 100_000_0){
                break;
            }else{                
                sum += sums[end++];
            }
        }

        if(isSolved){
            bw.write(start + " " + end + "\n");
        }else{
            bw.write("0 0");
        }

        bw.flush();

    }
    
}
