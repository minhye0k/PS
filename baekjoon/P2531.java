import java.io.*;
import java.util.*;

public class P2531 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Map<Integer, Integer> m = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for(int i=0; i<N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        boolean[] isVisited = new boolean[d+1];

        int start = 0, end = 0;
        int count = 0;
        int result = 0;
        int answer = 0;
        // end <= N+k-1
        while(true){
            if(count >= k){
                int idx = sushi[start%N];
                Integer cnt = m.get(idx);
                if(cnt - 1 == 0){
                    m.remove(idx);
                    result--;
                }else{
                    m.put(idx, cnt - 1);
                }
                start++;
                count--;
            }else if(end >= N+k-1){
                break;
            }else{
                int idx = sushi[end%N];

                if(!m.containsKey(idx)){
                    result++;
                    m.put(idx, 1);
                    answer = Math.max(result, answer);
                }else{
                    m.put(idx,m.get(idx) + 1);
                }

                if(!m.containsKey(c)){
                    answer = Math.max(result+1,answer);
                }
                end++;
                count++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
