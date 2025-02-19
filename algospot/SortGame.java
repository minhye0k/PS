import java.util.*;

public class SortGame {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        precalc();

        while(C-- > 0) {
            int N = sc.nextInt();

            List<Integer> perms = new ArrayList<>();
            for(int i=0; i<N; i++){
                perms.add(sc.nextInt());
            }

            System.out.println(solve(perms));
            
        }

        sc.close();
    }

    static Map<List<Integer>, Integer> toSort = new HashMap<>();

    static void precalc(){
        List<Integer> perm = new ArrayList<>();
        for(int i=0; i<8; i++){
            perm.add(i);
        }

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(perm);
        toSort.put(perm, 0);

        while(!q.isEmpty()){
            List<Integer> here = q.poll();

            int dist = toSort.get(here);

            for(int i=0; i<perm.size(); i++){
                for(int j=1; j<perm.size(); j++){
                    List<Integer> next = new ArrayList<>(here);
                    reverse(next, i, j);
                    
                    if(toSort.containsKey(next)) continue;
                    q.add(next);
                    toSort.put(next,dist+1);
                }
            }
            

        }
    }

    static void reverse(List<Integer> perms, int start, int end){
        while(start < end){
            int a = perms.get(start);
            int b = perms.get(end);

            perms.set(end, a);
            perms.set(start, b);

            start++; end--;
        }
    }

    static int solve(List<Integer> perm) {
        List<Integer> fixed = new ArrayList<>();

        boolean[] visited = new boolean[8];

        for (Integer num : perm) {
            int smaller = 0;
            for (Integer candidate : perm) {
                if(num > candidate) smaller++;
            }
            visited[smaller] = true;
            fixed.add(smaller);
        }

        for(int i=0; i<8; i++){
            if(!visited[i]) fixed.add(i);
        }

        return toSort.get(fixed);
    }
    
}
