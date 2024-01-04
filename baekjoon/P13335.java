import java.util.*;

public class P13335 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] truck = new int[n];

        int w = sc.nextInt();

        int[] bridge = new int[w];
        Arrays.fill(bridge, -1);

        int L = sc.nextInt();

        for(int i=0; i<n; i++){
            truck[i] = sc.nextInt();
        }

        int result = 0;
        int idx = 0;
        int weight = 0;

        sc.close();

        while(true){
            if(idx == n && weight == 0){
                System.out.println(result);
                break;
            }
            result++;


            if(bridge[0] != -1){
                weight -= truck[bridge[0]];
            }

            pullFront(bridge);

            if(idx >= n) continue;

            if(weight + truck[idx] <= L){
                bridge[w-1] = idx;
                weight += truck[idx++];
            }

        }

    }

    static void pullFront(int[] bridge){
        int size = bridge.length;

        for(int i=1; i<size; i++){
            bridge[i-1] = bridge[i];
        }
        bridge[size-1] = -1;
    }

    static void print(int[] bridge){
        int size = bridge.length;
        for(int i=0; i<size; i++){
            System.out.print(bridge[i] + " ");
        }
        System.out.println();
    }
}
