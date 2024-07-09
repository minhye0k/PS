import java.util.*;
import java.io.*;

public class P11652 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        // quickSort(arr,0,N-1);
        Arrays.sort(arr);

        int cnt = 1;
        long result = arr[0];
        int maxCnt = 1;
        for(int i=1; i<N; i++){
            long num = arr[i];
            if(arr[i-1] == num){
                cnt++;
            }else{
                cnt = 1;
            }

            if(cnt > maxCnt){
                maxCnt = cnt;
                result = num;
            }
        }
        // print(arr);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
    

    static void quickSort(long[] arr, int left, int right){
        if(left >= right) return;

        int pi = partition(arr, left, right);

        quickSort(arr, left, pi-1);
        quickSort(arr,pi+1, right);
    }

    static int partition(long[] arr, int i, int j){
        long pivot = arr[i];

        int lo = i;
        int hi = j;

        while(lo<hi){
            while(lo < hi && arr[hi] >= pivot) hi--;
            while(lo < hi && arr[lo] <= pivot) lo++;

            if(lo<hi) swap(arr,lo,hi);
        }

        swap(arr,lo,i);
        return lo;

    }

    static void swap(long[] arr, int i, int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(long[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
    
    
}
