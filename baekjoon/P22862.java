import java.util.*;
import java.io.*;

public class P22862 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0, cnt = 0;
        int start = 0, end = 0;

        while(true){
            if(end >= N) break;
            int num = arr[end];
            if(cnt<K){
                if(num % 2 == 1) cnt++;
                end++;
                result = Math.max(result, end-start-cnt);
            }else if(num % 2 != 0){
                if(arr[start++] % 2 != 0) cnt--;
            }else{
                end++;
                result = Math.max(result, end-start-cnt);
            }
        }
        
        bw.write(result + "\n");
        bw.flush();




    }
    
}
