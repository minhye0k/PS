import java.util.*;

public class Potion {
    static int n;
    static int[] r, p;
    static int[] answer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        while(c-- > 0){
            n = sc.nextInt();

            r = new int[n];
            p = new int[n];
            answer = new int[n];

            for(int i=0; i<n; i++){
                r[i] = sc.nextInt();
            }

            for(int i=0; i<n; i++){
                p[i] = sc.nextInt();
            }

            if(makeOneBottle()){
                printAnswer();
            }else{
                adjustRate();
                printAnswer();
            }
        }

        sc.close();
    }

    static void printAnswer(){
        for(int i=0; i<n; i++){
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    static boolean makeOneBottle(){
        boolean ret = true;

        for(int i=0; i<n; i++){
            if(p[i] > r[i]){
                p[i] -= r[i];
                ret = false;
            }else{
                answer[i] = r[i] - p[i];
                p[i] = 0;
            }
        }

        return ret;
    }

    static void adjustRate(){
        if(n==1) return;

        int gcd = gcd(r[0], r[1]);

        for(int i=2; i<n; i++){
            gcd = gcd(r[i], gcd);
        }

        for(int i=0; i<n; i++){
            r[i] /= gcd;
        }

        int maxRate = 0;
        for(int i=0; i<n; i++){
            int rate = (p[i] / r[i]) + (p[i] % r[i] != 0 ? 1 : 0);
            if(rate > maxRate){
                maxRate = rate;
            }
        }

        for(int i=0; i<n; i++){
            answer[i] += (r[i] * maxRate - p[i]);
        }
    }

    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
    
}
