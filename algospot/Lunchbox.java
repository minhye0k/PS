import java.util.*;

public class Lunchbox {
    static int N;
    static int[][] lunch;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0){
            N = sc.nextInt();
            lunch = new int[N][2];

            for(int i=0; i<N; i++){
                lunch[i][0] = sc.nextInt();
            }

            for(int i=0; i<N; i++){
                lunch[i][1] = sc.nextInt();
            }

            System.out.println(lunch());
        }

        sc.close();
    }

    static int lunch(){
        Arrays.sort(lunch, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] < o2[0] ? -1 : 1;
            }

            return o1[1] > o2[1] ? -1 : 1;
        });

        int ret = 0;
        int eatBegin = 0;
        for(int i=0; i<N; i++){
            eatBegin += lunch[i][0];
            ret = Math.max(ret, eatBegin + lunch[i][1]);
        }

        return ret;
        
    }
    
}
