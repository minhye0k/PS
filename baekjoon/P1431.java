import java.util.*;
import java.io.*;

public class P1431 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] strs = new String[N];
        
        for(int i=0; i<N; i++){
            strs[i] = br.readLine();
        }

        // System.out.println();
        quickSort(strs, 0,strs.length-1);
        for(int i=0; i<N; i++){
            bw.write(strs[i] + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    static void quickSort(String[] strs, int left, int right){
        if(left >= right){
            return;
        }

        int pivot = partition(strs, left, right);
        
        quickSort(strs,left, pivot-1);
        quickSort(strs,pivot+1, right);


    }

    static int partition(String[] strs, int left, int right){
        String pivot = strs[left];

        int i = left;
        int j = right;

        while(i < j){
            while(i < j && compareTo(pivot, strs[j])){
                j--;
            }

            while(i < j && compareTo(strs[i], pivot)){
                i++;
            }
        
            if(i < j) swap(strs,i,j);
        }
        
        swap(strs, left, j);
        
        // print(strs);
        return j;
    }

    static void swap(String[] strs, int i, int j){
        // System.out.println("swap : " + strs[i] + "," + strs[j]);
 
        String s = strs[i];
        strs[i] = strs[j];
        strs[j] = s;

    }

    static boolean compareTo(String a, String b){
        if(a.length() != b.length()) return a.length() < b.length();

        int sumA = sum(a);
        int sumB = sum(b);

        if(sumA != sumB) return sumA < sumB;

        return a.compareTo(b) <= 0;
    }

    static int sum(String s){
        int ret = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c > '9' || c < '0') continue;
            ret += c - '0';
        }

        return ret;
    }

    static void print(String[] strs){
        for(String s : strs){
            System.out.println(s);
        }

        System.out.println();
    }

}
