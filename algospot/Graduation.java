import java.util.*;

/* 
1. int graduation (semester, taken) 수강 학기, 지금까지 들은거
2. 안듣는 경우의 수, 듣는 경우의 수
3. 들을 수 있는 과목만 걸러냄
 3-1. 이번 학기 과목 중 안들은거 먼저 찾음
 3-2. 선수 과목 안들은 거 제외
4. 한 학기 l 과목 까지만 들을 수 있음
5. bit count 로 체크
*/


public class graduation {

    static final int MAX_N = 12;
    static final int INF = 987654321;

    static int[] prerequisite = new int[MAX_N];
    static int[] classes = new int[10];
    static int[][] cache = new int[10][1<<MAX_N];

    static int n,k,m,l;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        while(tc-- > 0){
            prerequisite = new int[MAX_N];
            classes = new int[10];
            cache = new int[10][1<<MAX_N];

            n = sc.nextInt();
            k = sc.nextInt();
            m = sc.nextInt();
            l = sc.nextInt();

            initCache();

            for(int i=0; i<n; i++){
                int pre = sc.nextInt();
                prerequisite[i] = 0;
                for(int j=0; j<pre; j++){
                    prerequisite[i] |= (1 << sc.nextInt());
                }
            }

            for(int i=0; i<m; i++){
                int c = sc.nextInt();
                classes[i] = 0;
                for(int j=0; j<c; j++){
                    classes[i] |= (1 << sc.nextInt());
                }
            }

            int result = graduate(0,0);
            if(result == INF){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(result);
            }
        }

        sc.close();
    }

    static void initCache(){
        for(int i=0; i<10; i++){
            Arrays.fill(cache[i], -1);
        }
    }

    static int graduate(int semester, int taken){
        if(bitCount(taken) >= k) return 0; 
        if(semester == m) return INF;
        
        if(cache[semester][taken] != -1) return cache[semester][taken];

        int ret = INF;

        int canTake = (classes[semester] & ~taken);

        for(int i=0; i<n; i++){
            if(((canTake & (1 << i)) > 0) && ((taken & prerequisite[i]) != prerequisite[i])){
                canTake &= ~(1<<i);
            }
        }

        for(int take = canTake; take > 0; take = ((take-1) & canTake)){
            if(bitCount(take) > l) continue;
            ret = Math.min(ret, graduate(1 + semester, taken | take) + 1);
        }

        ret = Math.min(ret, graduate(1 + semester, taken));
        cache[semester][taken] = ret;
        return ret;
    }

    static int bitCount(int n){
        if(n==0) return 0;
        
        if((n&1) == 1) return 1 + bitCount(n >> 1);
        else return bitCount(n >> 1);
    }
    
}

