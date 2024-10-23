import java.util.*;
import java.io.*;

public class fanmeeting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            String m = br.readLine();
            String f = br.readLine();
            

            bw.write(hugs(m,f) + "\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int hugs(String m, String f){
        int ret = 0;


        List<Integer> me = new ArrayList<>();
        for(int i=0; i<m.length(); i++){
            me.add(m.charAt(i) == 'M' ? 1 : 0);
        }
        
        List<Integer> fa = new ArrayList<>();
        for(int i=0; i<f.length(); i++){
            fa.add(f.charAt(i) == 'M' ? 1 : 0);
        }

        List<Integer> c = karatsuba(me,fa);

        for(int i=m.length()-1; i<f.length(); i++){
        // for(int i=0; i<c.length; i++){
            if(c.get(i)==0) ret++;
        }
        
        return ret;
    }

    static List<Integer> karatsuba(List<Integer> a, List<Integer> b){
        int an = a.size(), bn = b.size();
        if(an == 0 || bn == 0) return Collections.emptyList();
        if(an < bn) return karatsuba(b, a);
        if(an <= 50) return multiply(a, b);

        int half = an / 2;

        ArrayList<Integer> a0 = new ArrayList<Integer>(a.subList(0, half));
        ArrayList<Integer> a1 = new ArrayList<Integer>(a.subList(half, an));

        int bHalf = Math.min(half, bn);
        ArrayList<Integer> b0 = new ArrayList<Integer>(b.subList(0, bHalf));
        ArrayList<Integer> b1 = new ArrayList<Integer>(b.subList(bHalf, bn));

        List<Integer> z0 = karatsuba(a0, b0);
        List<Integer> z2 = karatsuba(a1, b1);
        addTo(a0, a1,0); 
        addTo(b0, b1,0);

        List<Integer> z1 = karatsuba(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);

        ArrayList<Integer> ret = new ArrayList<>();
        addTo(ret, z0, 0);
        addTo(ret, z1, half);
        addTo(ret, z2, half * 2);

        return ret;
    }

    static ArrayList<Integer> multiply(List<Integer> a, List<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();

        for(int i=0; i<a.size()+b.size(); i++){
            c.add(0);
        }

        for(int i=0; i<a.size(); i++){
            for(int j=0; j<b.size(); j++){
                c.set(i+j, c.get(i+j) + a.get(i) * b.get(j));
            }
        }

        return c;
    }

    static List<Integer> addTo(ArrayList<Integer> a, List<Integer> b, int k){
        int an = a.size(), bn = b.size();

        int size = (bn + k) > an ? (bn + k) : an;
        a = ensureSize(a, size);

        for(int i=0; i<bn; i++){
            a.set(i+k, a.get(i+k) + b.get(i));
        }

        return a;
    }

    static void subFrom(List<Integer> a, List<Integer> b){
        // System.out.println("an size : " + a.length + ", " + b.length);
        for(int i=0; i<b.size(); i++){
            a.set(i, a.get(i) - b.get(i));
        }

    }

    private static ArrayList<Integer> ensureSize(ArrayList<Integer> c, int size){
        c.ensureCapacity(size);
        while(c.size()<size) {
            c.add(0);
        }
        return c;
    }
}
