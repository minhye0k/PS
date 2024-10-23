import java.util.*;

public class snail {
    static double[][] d;
    static int n, m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        
        while(C-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();

            d = new double[m][m*2];

            for(int i=0; i<m; i++){
                Arrays.fill(d[i], -1);
            }

            System.out.println(probability(0, 0));
        }

        sc.close();
    }

    static double probability(int days, int climbed){
        if(days == m) return climbed >= n ? 1 : 0;
        if(d[days][climbed] != -1) return d[days][climbed];

        double ret = 0.25 * probability(days+1, climbed+1) + 0.75 * probability(days+1, climbed+2);

        d[days][climbed] = ret;

        return ret;
    }
    
}
