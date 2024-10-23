import java.util.*;

public class Minastirith {
    static class Point {
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        double x;
        double y;
    }

    static List<Point> ranges;
    static double[] x;
    static double[] y;
    static double[] r;
    static final int INF = 987654321;

    static int count;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            count = sc.nextInt();
            x = new double[count];
            y = new double[count];
            r = new double[count];

            ranges = new ArrayList<>();

            for(int i=0; i<count; i++){
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
                r[i] = sc.nextDouble();
            }
            coverToRange();

            int ret = solve();

            if(ret == INF){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(ret);
            }
        }

        sc.close();
    }

    static void coverToRange(){
        for(int i=0; i<count; i++){
            double loc = (2 * Math.PI + Math.atan2(x[i], y[i])) % (2 * Math.PI);
            double range = 2.0 * Math.asin(r[i]/ 2.0 / 8.0);

            ranges.add(new Point(loc - range, loc + range));
        }

        ranges.sort((p1, p2) -> {
            return (p1.x - p2.x >=0) ? 1 : -1;
        });
    }

    static int solve(){
        int ret = INF;
        for(int i=0; i<count; i++){
            Point range = ranges.get(i);
            if(range.x <= 0.0 || range.y >= 2 * Math.PI){
                double begin = range.y % (2*Math.PI);
                double end = ((2*Math.PI) + range.x) % (2*Math.PI);

                ret = Math.min(ret, solveLinear(begin,end) + 1);
            }
        }

        return ret;
    }

    static int solveLinear(double begin, double end){
        int used = 0, idx = 0;

        while(begin < end){
            double maxCover = -1;
            while(idx < count && ranges.get(idx).x <= begin){
                maxCover = Math.max(maxCover, ranges.get(idx).y);
                idx++;
            }

            if(maxCover <= begin) return INF;

            begin = maxCover;
            used++;
        }

        return used;
    }
    
}
