import java.util.*;

public class Dictionary {
    static int[][] adj;
    static boolean[] seen;
    static List<Integer> orders;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0) {
            adj = new int[26][26];
            seen = new boolean[26];
            orders = new ArrayList<>();

            int N = sc.nextInt();

            List<String> words = new ArrayList<>();
            sc.nextLine();
            for (int i=0; i<N; i++) {
                words.add(sc.nextLine());
            }

            makeGraph(words);
            solve();

        }

        sc.close();
    }

    static void makeGraph(List<String> words){
        for(int j=1; j<words.size(); j++) {
            int i = j-1;

            String preWord = words.get(i);
            String postWord = words.get(j);

            int len = Math.min(preWord.length(), postWord.length());
            
            for(int k=0; k<len; k++) {
                char pre = preWord.charAt(k);
                char post = postWord.charAt(k);
                if(pre == post) continue;
                adj[pre - 'a'][post - 'a'] = 1;
                break;
            }
        }
    }

    static void solve() {
        for(int i=0; i<adj.length; i++) if(!seen[i]) dfs(i);

        Collections.reverse(orders);

        for(int i=0; i<adj.length; i++){
            for(int j=i+1; j<adj.length; j++){
                if(adj[orders.get(j)][orders.get(i)] == 1){
                    System.out.println("INVALID HYPOTHESIS");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<orders.size(); i++){
            char c = (char) (orders.get(i) + 'a');
            sb.append(c);
        }

        System.out.println(sb.toString());
    }

    static void dfs(int here){
        seen[here] = true;

        for(int there=0; there<adj[here].length; there++){
        
            if(seen[there] || adj[here][there] == 0) continue;
            
            dfs(there);
        }

        orders.add(here);
    }
    
}