import java.util.*;

public class pass486 {
    static final int MAX = 10_000_000;

    static int[] minFactor = new int[MAX+1];
    static byte[] minFactorPower = new byte[MAX+1];
    static int[] factors = new int[MAX+1];
    static int lo, hi, n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        setMinFactors();
        setFactors();

        while(c-- > 0){
            n = sc.nextInt();
            lo = sc.nextInt();
            hi = sc.nextInt();

            int answer = 0;
            for(int i=lo; i<=hi; i++){
                if(factors[i] == n) answer++;
            }

            System.out.println(answer);

        }

        sc.close();
    }

    static void setMinFactors(){
        minFactor[0] = -1;
        minFactor[1] = -1;
        for(int i=2; i<=MAX; i++){
            minFactor[i] = i;
        }

        int maxRoot = (int) Math.sqrt(MAX);
        for(int i=2; i<=maxRoot; i++){
            for(int j=i*i; j<=MAX; j+=i){
                if(minFactor[j] == j){
                    minFactor[j] = i;
                }
            }
        }
    }

    static void setFactors(){
        factors[1] = 1;
        for(int n = 2; n <= MAX; n++){
            if(minFactor[n] == n){
                minFactorPower[n] = 1;
                factors[n] = 2;
            }else{
                int p = minFactor[n];
                int m = n / p;

                if(p != minFactor[m]){
                    minFactorPower[n] = 1;
                }else{
                    minFactorPower[n] = (byte) (minFactorPower[m] + 1);
                }

                int a = minFactorPower[n];
                factors[n] = (factors[m] / a) * (a + 1);
            }
        }
    }
    

}
