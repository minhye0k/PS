import java.util.*;

public class tripathcnt {
    static int[][] triangle;
    static int[][] maxCache;
    static int[][] cntCache;
    static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            n = sc.nextInt();
            
            triangle = new int[n][n];
            maxCache = new int[n][n];
            cntCache = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<=i; j++){
                    triangle[i][j] = sc.nextInt();
                }
            }

            triangleMax(0,0);
            System.out.println(count(0,0));
        }

        sc.close();
    }

    static int triangleMax(int x, int y){
        if(x == n-1) {
            maxCache[x][y] = triangle[x][y];
            return triangle[x][y];
        }

        if(maxCache[x][y] != 0) return maxCache[x][y];

        int ret = triangle[x][y] + Math.max(triangleMax(x+1,y), triangleMax(x+1,y+1));

        maxCache[x][y] = ret;

        return ret;
    }

    static int count(int x, int y){
        if(x == n-1) return 1;

        if(cntCache[x][y] != 0) return cntCache[x][y];

        int ret = 0;

        if(maxCache[x+1][y+1] <= maxCache[x+1][y]) ret += count(x+1, y);
        if(maxCache[x+1][y+1] >= maxCache[x+1][y]) ret += count(x+1, y+1);

        cntCache[x][y] = ret;
        return ret;
    }
    
}
