import java.util.*;

public class Childrenday {
    static int N, M;
    static String digits;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        sc.nextLine();

        while (C-- > 0) {
            String inputs[] = sc.nextLine().split(" ");

            digits = inputs[0];
            char[] chars = digits.toCharArray();
            Arrays.sort(chars);
            digits = new String(chars);

            N = Integer.parseInt(inputs[1]);
            M = Integer.parseInt(inputs[2]);

            System.out.println(solve());
        }

        sc.close();
    }

    static String solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int[] parent = new int[2*N];
        int[] choice = new int[2*N];
        Arrays.fill(parent, -1);
        Arrays.fill(choice, -1);

        parent[0] = 0;


        while(!q.isEmpty()){
            int here = q.poll();

            for(int i=0; i<digits.length(); i++) {
                int digit = digits.charAt(i) - '0';
                int there = append(here, digit, N);

                if(parent[there] != -1) continue;
                parent[there] = here;
                choice[there] = digit;
                q.add(there);
            }
        }

        int here = N+M;
        if(parent[here] == -1) return "IMPOSSIBLE";
        
        StringBuilder ret = new StringBuilder();
        while(parent[here] != here){
            ret.append((char) (choice[here] + '0'));
            here = parent[here];
        }
        ret.reverse();
        return ret.toString();
    }

    static int append(int here, int edge, int mod){
        int there = here * 10 + edge;

        if(there >= mod) return mod + there % mod;

        return there;
    }
    
}
