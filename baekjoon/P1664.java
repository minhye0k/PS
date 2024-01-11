import java.util.*;

public class P1664 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime, true);

        for(int i=2; i*i<=N; i++){
            if(!prime[i]) continue;

            for(int j=i*i; j<=N ;j+=i){
                prime[j] = false;
            }
        }

        for(int i=2; i<N+1; i++){
            if(prime[i]) arr.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        int result = 0;

        while(true){
            if(sum > N){
                sum -= arr.get(start++);
            }else if(sum == N){
                result++;
                sum -= arr.get(start++);
            }else if(end >= arr.size()){
                break;
            }else{
                sum += arr.get(end++);
            }
        }

        System.out.println(result);



        sc.close();
    }
}
