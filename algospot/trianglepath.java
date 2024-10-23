import java.io.*;
import java.util.*;

public class trianglepath {
    static int n;
    static int[][] cache;
    static int[][] tri;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            n = Integer.parseInt(br.readLine());

            cache = new int[n][n];
            tri = new int[n][n];

            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<=i; j++){
                    tri[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(maxPath(0,0));
        }
        
        br.close();
        bw.close();
    }

    static int maxPath(int x, int y){
        if(cache[x][y] != 0){
            return cache[x][y];
        }

        if(x==n-1){
            cache[x][y] = tri[x][y];
            return cache[x][y];
        }

        int ret = tri[x][y] + Math.max(maxPath(x+1, y), maxPath(x+1, y+1));
        cache[x][y] = ret;
        return ret;
    }
}
