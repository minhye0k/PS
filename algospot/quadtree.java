import java.io.*;
import java.text.*;

public class quadtree {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            String s = br.readLine();
            
            bw.write(reverse(new StringCharacterIterator(s)) + "\n");
            
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static String reverse(CharacterIterator iter){
        char c = iter.current();
        iter.next();
        
        if(c=='w' || c=='b') return String.valueOf(c);
        
        String leftUp = reverse(iter);
        String rightUp = reverse(iter);
        String leftDown = reverse(iter);
        String rightDown = reverse(iter);

        return new StringBuffer()
        .append("x")
        .append(leftDown)
        .append(rightDown)
        .append(leftUp)
        .append(rightUp)
        .toString();
    }


    
}
