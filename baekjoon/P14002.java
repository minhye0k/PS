import java.io.*;

public class P14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String[] numbers = s.split(" ");

        int[] A = new int[N+1];

        for(int i=0; i<N; i++){
            A[i+1] = Integer.parseInt(numbers[i]);
        }

        int[] dp = new int[N+1];
        int[] child = new int[N+1];

        for(int i=1; i<=N; i++){
            dp[i] = 1;
            child[i] = i;
            for(int j=1; j<i; j++){
                if(A[i] > A[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        child[i] = j;
                    }
                }
            }
        }

        int maxIdx = 0;
        int max = 0;
        for(int i=1; i<=N; i++){
            if(dp[i] > max){
                max = dp[i];
                maxIdx = i;
            }
        }

        bw.write(max + "\n");
        printLIS(bw, A,child, maxIdx);
        bw.write("\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void printLIS(BufferedWriter bw, int[] A, int child[], int idx) throws IOException{
        if(child[idx] == idx){
            bw.write(A[idx] + " ");
            return;
        }

        printLIS(bw,A,child ,child[idx]);
        bw.write(A[idx] + " ");
    }
    
}
