import java.util.*;
import java.io.*;

public class P20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cnt = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int start = 0, end = 0;
        int result = 0;


        while(true){
            int num = arr[end];
            if(cnt[num] >= K){
                int n = arr[start++];
                cnt[n]--;
            }else{
                end++;
                cnt[num]++;
                result = Math.max(result,end-start);

                if(end >= N) break;
            }
        }

        bw.write(result + "\n");
        bw.flush();


    }
}
