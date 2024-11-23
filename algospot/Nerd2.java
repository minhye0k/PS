import java.util.*;
import java.util.Map.Entry;
import java.io.*;


public class Nerd2 {
    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            // (a,b) -> {
            //     return b - a;
            // }
            map = new TreeMap<>();
            long answer = 0;

            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++){
                String[] inputs = br.readLine().split(" ");
                int p = Integer.parseInt(inputs[0]);
                int q = Integer.parseInt(inputs[1]);

                answer += nerd(p, q);
            }
            System.out.println(answer);
        }

        br.close();
    }

    static int nerd(int p, int q){
        if(isDominated(p, q)) return map.size();

        removeDominated(p, q);
        map.put(p, q);
        return map.size();
    }

    static boolean isDominated(int p, int q){
        Entry<Integer, Integer> coor = map.higherEntry(p);
        if(coor == null) return false;

        return coor.getValue() > q;
    }

    static void removeDominated(int p, int q){
        Entry<Integer, Integer> entry = map.lowerEntry(p);

        while(entry != null){
            if(entry.getValue() > q) break;
            map.remove(entry.getKey());
            entry = map.lowerEntry(p);
        }
        
    }
    
}
