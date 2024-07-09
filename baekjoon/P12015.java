import java.util.*;
import java.io.*;

public class P12015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();

        String s = br.readLine();
        String[] numbers = s.split(" ");

        for(int i=0; i<N; i++){
            int number = Integer.parseInt(numbers[i]);
            if(i>0) {
                if(number > A.get(A.size()-1)){
                    A.add(number);
                }else{
                    int lower = lowerBound(number, A);
                    A.set(lower, number);
                }
            }else{
                A.add(number);
            }
        }

        bw.write(A.size() + "\n");
        for(Integer num : A){
            bw.write(num + " ");
        }
        bw.write("\n");
        bw.flush();


        bw.close();
        br.close();
    }

    static int lowerBound(int value, List<Integer> A){
        int start = -1;
        int end = A.size();

        while(start + 1 < end){
            int mid = (end+start) / 2;
            
            if(A.get(mid) < value) start = mid;
            else end = mid;
        }

        return end;
    }

    
}
