import java.io.*;
import java.util.*;

public class P11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Set<String> set = new HashSet<>();

        for(int i=1; i<=s.length(); i++){
            for(int j=0; j+i<=s.length(); j++){
                String substring = s.substring(j,j+i);
                if(!set.contains(substring)){
                    set.add(substring);
                }else continue;
            }
        }

        bw.write(String.valueOf(set.size()) + '\n');
        bw.flush();

        bw.close();
        br.close();

    }
}
