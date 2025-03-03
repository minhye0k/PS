import java.io.IOException;
import java.util.*;
import java.io.*;

public class Hanoi4 {
    static int start, finish, N;

    public static void main(String[] args) throws IOException{
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            N = Integer.parseInt(br.readLine());

            start = 0; finish = 0;

            for(int i=0; i<4; i++){
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                for(int j=0; j<n; j++){
                    int disk = Integer.parseInt(input[j+1]);
                    start = set(start, disk-1, i);
                }
            }

            for(int i=0; i<N; i++){
                finish = set(finish, i, 3);
            }

            int ret = bfs();
            System.out.println(ret);
        }

        // sc.close();
        br.close();
    }

    static int get(int state, int index){
        return (state >> index * 2) & 3;
    }

    static int set(int state, int index, int value){
        return (state & ~(3 << (index * 2))) | (value << (index * 2));
    }

    static byte[] c;

    static int bfs(){
        if(start == finish) return 0;
        c = new byte[1 << N*2];

        c[start] = 1;
        c[finish] = -1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(finish);

        while(!q.isEmpty()){
            int here = q.poll();

            int[] top = {-1, -1, -1, -1};

            for(int i=N-1; i>=0; i--){
                top[get(here, i)] = i;
            }

            for(int i=0; i<4; i++){
                if(top[i] == -1) continue;
                
                for(int j=0; j<4; j++){
                    if(i==j) continue;
                    if(top[j] != -1 && top[i] > top[j]) continue;
                
                    int there = set(here, top[i], j);

                    if(c[there] == 0){
                        c[there] = incr(c[here]);
                        q.add(there);
                    }else if(sgn(c[there]) != sgn(c[here])){
                        return Math.abs(c[there]) + Math.abs(c[here]) - 1;
                    }
                
                }
                

            }
        }

        return -1;
    }

    static int sgn(byte x){
        return x < 0 ? -1 : 1;
    }

    static byte incr(byte x) {
        if(x < 0) return (byte) (x-1);
        else return (byte) (x+1);
    }

    
}
