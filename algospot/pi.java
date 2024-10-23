import java.util.*;
import java.io.*;

public class pi {
    static int N;
    static int arr[];
    static int d[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        sc.nextLine();

        while(C-- > 0){
            String s = sc.nextLine();

            N = s.length();
            arr = new int[N];
            d = new int[N];
            
            for(int i=0; i<N; i++){
                arr[i] = s.charAt(i) - '0';
            }


            System.out.println(difficulty(0));
        }
    }

    static int difficulty(int n){
        if(n==N) return 0;
        if(d[n] != 0) return d[n];

        int ret = 987654321;

        for(int i=2; i<5; i++){
            if(n+i+1 > N) continue;

            ret = Math.min(ret, classify(n,n+i) + difficulty(n+i+1));

        }
        d[n] = ret;
        return ret;
    }

    static int classify(int a, int b){
        boolean pass = true;

        for(int i=a+1; i<=b; i++){
            if(arr[a] != arr[i]) {
                pass = false;
                break;
            }
        }

        if(pass) return 1;

        pass = true;
        for(int i=a+1; i<b; i++){
            if((arr[i+1] - arr[i]) != (arr[a+1] - arr[a])) {
                pass = false;
                break;
            }
        }

        if(pass && (Math.abs(arr[a+1] - arr[a]) == 1)) return 2;

        boolean alternating = true;
        for(int i=a+2; i<=b; i++){
            if(arr[i] != arr[i-2]){
                alternating = false;
                break;
            }
        }
        if(alternating) return 4;
        if(pass) return 5;

        return 10;

    }


    
}
