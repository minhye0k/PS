import java.util.*;

public class wordchain {
    static int[] inDegree;
    static int[] outDegree;
    static int[][] adj;
    static List<String>[][] edges;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while (C-- > 0) {
            int N = sc.nextInt();
            List<String> words = new ArrayList<>();
            sc.nextLine();
            for(int i=0; i<N; i++){
                words.add(sc.nextLine());
            }
            
            makeGraph(words);
            if(!isEuler()) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            String answer = searchEuler(words.size());
            System.out.println(answer);
        }

        sc.close();
    }
    
    static void makeGraph(List<String> words) {
        edges = new ArrayList[26][26];

        for(int i=0; i<26; i++){
            for(int j=0; j<26; j++){
                edges[i][j] = new ArrayList<String>();
            }
        }
        adj = new int[26][26];
        outDegree = new int[26];
        inDegree = new int[26];

        for(String word : words){
            int a = word.charAt(0) - 'a';
            int b = word.charAt(word.length() - 1) - 'a';

            adj[a][b]++;
            outDegree[a]++;
            inDegree[b]++;

            edges[a][b].add(word);
        }
    }

    static boolean isEuler() {
        int start = 0;
        int end = 0;
        for(int i=0; i<26; i++){
            int diff = inDegree[i] - outDegree[i];

            if(diff < -1 || diff > 1) return false;

            if(diff == 1) end++;
            if(diff == -1) start++;
        }

        return (start == 1 && end == 1) || (start == 0 && end == 0);
    }

    static String searchEuler(int size){
        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new ArrayList<>();

        boolean found = false;
        for(int i=0; i<26; i++){
            if(outDegree[i] == inDegree[i] + 1){
                searchEuler(i, answer);
                found = true;
                break;
            }
        }

        if(!found){
            for(int i=0; i<26; i++){
                if(outDegree[i] > 0){
                    searchEuler(i, answer);
                    break;
                }
            }   
        }

        if(answer.size() != (size + 1)) return "IMPOSSIBLE";

        Collections.reverse(answer);

        for(int i=1; i<answer.size(); i++){
            int a = answer.get(i-1); 
            int b = answer.get(i);

            if(sb.length() != 0) sb.append(" ");
            sb.append(edges[a][b].get(0));
            edges[a][b].remove(0);
        }

        return sb.toString();
    }

    static void searchEuler(int here, List<Integer> answer){

        for(int there=0; there < adj.length; there++){
            while(adj[here][there] > 0){
                adj[here][there]--;
                searchEuler(there, answer);
            }
        }

        answer.add(here);
    }
}
