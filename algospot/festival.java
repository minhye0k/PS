import java.io.*;

public class festival {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.valueOf(br.readLine());

        while(c-- > 0){
            String[] input = br.readLine().split(" ");

            int N = Integer.valueOf(input[0]);
            int L = Integer.valueOf(input[1]);

            double answer = 100000;

            int[] sum = new int[N+1];
            sum[0] = 0;

            input = br.readLine().split(" ");

            for(int i=0; i<input.length; i++){
                int value = Integer.valueOf(input[i]);
                sum[i+1] = sum[i] + value;
            }

            for(int i=1; i<=N-L+1; i++){
                for(int j=i+L-1; j<=N;j++){
                    double d = (double)(sum[j] - sum[i-1])/(double)(j-i+1);

                    answer = Math.min(d, answer);
                }
            }

            bw.write(answer + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
