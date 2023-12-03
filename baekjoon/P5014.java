import java.util.*;

public class P5014 {
    static int F, S, G, U, D;
    static boolean[] isVisited;

    static class Pair{
        int x;
        int cnt;

        Pair(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }


    static boolean OOB(int x){
        return x < 1 || x > F;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        sc.close();

        isVisited = new boolean[F+1];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(S,0));
        isVisited[S] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.x == G) {
                System.out.println(p.cnt);
                return;
            }

            if(!(OOB(p.x+U) || isVisited[p.x+U])){
                q.add(new Pair(p.x+U, p.cnt+1));
                isVisited[p.x+U] = true;
            }

            if(!(OOB(p.x-D) || isVisited[p.x-D])){
                q.add(new Pair(p.x-D, p.cnt+1));
                isVisited[p.x-D] = true;
            }
        }

        System.out.println("use the stairs");

    }
}
