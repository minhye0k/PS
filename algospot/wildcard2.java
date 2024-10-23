import java.io.*;
import java.util.*;

public class wildcard2 {
    static int N;
    static String pattern;
    static String filename;

    static int[][] cache = new int[101][101];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            pattern = br.readLine();

            N = Integer.parseInt(br.readLine());

            List<String> answerList = new ArrayList<>();
            
            for(int i=0; i<N; i++){
                initCache();

                filename = br.readLine();

                boolean isMatches = isMatches(0, 0);
                if(isMatches){
                    answerList.add(filename);
                }
            }
            Collections.sort(answerList);
                
            answerList.forEach(System.out::println);
        }

        br.close();
        bw.close();
    }

    static void initCache(){
        for(int i=0; i<101; i++){
            Arrays.fill(cache[i], -1);
        }
    }

    static boolean isMatches(int a, int b){

        if(cache[a][b] != -1) return cache[a][b] == 1;

        while((a < pattern.length() && b < filename.length())
        && (pattern.charAt(a) == '?' || pattern.charAt(a) == filename.charAt(b))){
            a++;
            b++;
        }

        if(a == pattern.length()){
            boolean matches = b == filename.length();
            cache[a][b] = matches ? 1 : 0;
            return matches;
        }

        if(pattern.charAt(a) == '*'){
            if(isMatches(a+1, b) || (b < filename.length() && isMatches(a, b+1))){
                cache[a][b] = 1;
                return true;
            }
        }

        cache[a][b] = 0;
        return false;


    }


    
}

