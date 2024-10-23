import java.util.*;
import java.io.*;

public class quantize {
    static final int INF = 987654321;
    static int[] arr;
    static int[][] d;
    static int[] sum, sSum;
    static int n, s;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();
            s = sc.nextInt();

            arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            d = new int[n][s+1];
            sum = new int[n];
            sSum = new int[n];

            Arrays.sort(arr);
            
            sum[0] = arr[0];
            sSum[0] = arr[0] * arr[0];

            for(int i=1; i<n; i++){
                sum[i] = arr[i] + sum[i-1];
                sSum[i] = arr[i] * arr[i] + sSum[i-1];
            }

            System.out.println(quantization(0, s));
        }

        sc.close();
    }

    static int quantization(int from, int parts){
        if(from == n) return 0;
        if(parts == 0) return INF;

        if(d[from][parts] != 0) return d[from][parts];

        int ret = INF;

        for(int i=1; from + i <= n; i++){
            ret = Math.min(ret, minError(from, from + i - 1) + quantization(from+i, parts-1));
        }

        d[from][parts] = ret;
        return ret;
    }

    static int minError(int a, int b){
        int partSum = sum[b] - (a == 0 ? 0 : sum[a-1]);
        int partSsum = sSum[b] - (a == 0 ? 0 : sSum[a-1]);

        int m = Math.round((float)partSum / (b-a+1));

        int ret = partSsum - 2 * m * partSum + m*m*(b-a+1);

        return ret;
    }
    
}
