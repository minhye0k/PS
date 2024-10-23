import java.io.*;
import java.util.StringTokenizer;

public class clocksync {
    static final int CLOCK_COUNT = 16;

    static String connected[] = {
        "xxx.............",
        "...x...x.x.x....",
        "....x.....x...xx",
        "x...xxxx........",
        "......xxx.x.x...",
        "x.x...........xx",
        "...x..........xx",
        "....xx.x......xx",
        ".xxxxx..........",
        "...xxx...x...x.."
    };

    static int clock[] = new int[CLOCK_COUNT];



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(C-- > 0){
            clock = new int[CLOCK_COUNT];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<CLOCK_COUNT; i++){
                clock[i] = Integer.parseInt(st.nextToken());
            }
            int result = solve(0);
            bw.write((result != 9999 ? result : -1) + "\n");
        }
        
        bw.flush();

        br.close();
        bw.close();
    }

    static int solve(int num){
        if(num == 10) return areAligned() ? 0 : 9999;

        int ret = Integer.MAX_VALUE;

        for(int i=0; i<4; i++){
            ret = Math.min(ret, i + solve(num+1));
            push(num);
        }

        return ret;
    }

    static boolean areAligned(){
        for(int i=0; i<CLOCK_COUNT; i++){
            if(clock[i] != 12) return false;
        }

        return true;
    }

    static void push(int num){
        for(int i=0; i<CLOCK_COUNT; i++){
            if(connected[num].charAt(i) == 'x') clock[i] += 3;
            if(clock[i] == 15) clock[i] = 3;
        }
    }
}
