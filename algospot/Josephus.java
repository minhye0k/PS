import java.util.*;

public class Josephus {
    static int N, K;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            N = sc.nextInt();
            K = sc.nextInt();

            josephus();
        }

        sc.close();
    }

    static void josephus() {
        LinkedList<Integer> soldiers = new LinkedList<>();
        for(int i=0; i<N; i++){
            soldiers.add(i+1);
        }
        int idx = 0;

        while(soldiers.size() > 2){
            soldiers.remove(idx);

            idx += K-1;
            int size = soldiers.size();
            if(idx >= size){
                idx %= size;
            }
        }

        for(int i=0; i<2; i++){
            System.out.print(soldiers.get(i) + " ");
        }
        System.out.println();

        
    }
    
}
