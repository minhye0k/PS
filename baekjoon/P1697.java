import java.util.*;

public class P1697 {

    static class Pair{
        int x;
        int cnt;

        Pair(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
    

    public static boolean OOB(int x){
        return x < 0 || x >100000;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        boolean[] isVisited = new boolean[100001];

        int subin = sc.nextInt();
        int brother = sc.nextInt();

        sc.close();

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(subin, 0));
        isVisited[subin] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int cnt = p.cnt;
            if(x == brother) {
                System.out.println(cnt);
                return;
            }

            if(!(OOB(x+1) || isVisited[x+1])){
                q.add(new Pair(x+1, cnt+1));
                isVisited[x+1] = true;
            }

            if(!(OOB(x-1) || isVisited[x-1])){
                q.add(new Pair(x-1, cnt+1));
                isVisited[x-1] = true;
            }

            if(!(OOB(x*2) || isVisited[x*2])){
                q.add(new Pair(x*2, cnt+1));
                isVisited[x*2] = true;
            }         
        }

        
    }
    
}
