import java.util.*;

public class Matchorder {
    static int[] russiaRatings;
    static int[] koreaRatings;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            int N = sc.nextInt();

            russiaRatings = new int[N];
            koreaRatings = new int[N];
            
            for(int i=0; i<N; i++){
                russiaRatings[i] = sc.nextInt();
            }

            for(int i=0; i<N; i++){
                koreaRatings[i] = sc.nextInt();
            }

            Arrays.sort(koreaRatings);

            System.out.println(win(N));
        }

        sc.close();
    }

    static int win(int N){
        int ret = 0;

        for(int i=0; i<N; i++){
            int russia = russiaRatings[i];
            if(russia == 0) continue;

            int min = 987654321;
            int minIdx = -1;

            boolean selected = false;

            for(int j=0; j<N; j++){
                int korea = koreaRatings[j];
                if(korea == 0) continue;

                if(korea >= russia){
                    selected = true;
                    koreaRatings[j] = 0;
                    russiaRatings[i] = 0;
                    ret++;
                    break;
                }

                if(korea < min){
                    min = korea;
                    minIdx = j;
                }
            }

            if(!selected){
                koreaRatings[minIdx] = 0;
                russiaRatings[i] = 0;
            }
        }

        return ret;
    }
    
}
