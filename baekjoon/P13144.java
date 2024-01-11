import java.util.*;
import java.io.*;

public class P13144 {

    public static void main(String[] args) throws IOException{

        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int []arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        Set<Integer> s = new HashSet<>();

        int start = 0, end = 0;
        long result = 0;
        int length = 0;

        while(true){
            int num = arr[end];

            if(s.contains(num)){
                s.remove(arr[start++]);
                length--;
            }else{
                s.add(num);
                end++;
                length++;
                result+=length;
            }


            if(end >= N) break;

        }
        bw.write(result + "\n");
        bw.close();
    }
    
}
