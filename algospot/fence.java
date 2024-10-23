import java.io.*;
import java.util.StringTokenizer;

public class fence {
    static int N;
    static int h[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(C-- > 0){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            h = new int[N];

            for(int i=0; i<N; i++){
                h[i] = Integer.parseInt(st.nextToken());
            }

            int ret = solve(0, N-1);

            bw.write(ret + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    static int solve(int left, int right){
        if(left == right) return h[left];

        int mid = (left + right) / 2;

        int ret = Math.max(solve(left, mid), solve(mid+1, right));

        int lo = mid, hi = mid+1;
        int height = Math.min(h[lo], h[hi]);
        ret = Math.max(ret, height * 2);

        while(left < lo || hi < right){
            if(hi < right && (lo == left || h[hi+1] > h[lo-1])){
                hi++;
                height = Math.min(height, h[hi]);
            }else{
                lo--;
                height = Math.min(height, h[lo]);
            }

            ret= Math.max(ret, height * (hi-lo+1));
        }

        return ret;

    }
    
}
