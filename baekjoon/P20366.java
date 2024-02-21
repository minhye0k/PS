import java.util.*;
import java.io.*;

public class P20366 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] snow = new int[N];
        for(int i=0; i<N; i++){
            snow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snow);

        int result = Integer.MAX_VALUE;
        
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                int snow1 = snow[i] + snow[j];

                int start = 0, end = N-1;

                while(start < end){
                    if(start == i || start == j) {
                        start++; continue;
                    }

                    if(end == i || end == j){
                        end--; continue;
                    }
                    int snow2 = snow[start] + snow[end];
                    result = Math.min(result, Math.abs(snow1- snow2));

                    if(snow1 > snow2){
                        start++;
                    }else if(snow1 < snow2){
                        end--;
                    }else{
                        bw.write(0 + "\n");
                        bw.flush();
                        return;
                    }
                }
            }

        }
        bw.write(result + "\n");
        bw.flush();
    }   
}
