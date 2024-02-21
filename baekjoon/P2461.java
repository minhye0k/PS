import java.util.*;
import java.io.*;

public class P2461 {
    public static class Student implements Comparable<Student>{
        int n;
        int score;

        public Student(int n, int score){
            this.n = n;
            this.score = score;
        }

        @Override
        public int compareTo(Student student){
            if(score < student.score) return -1;
            else if(score == student.score) return 0;
            else return 1;
        }
    }
    public static void main(String[] args) throws IOException{
        List<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int score = Integer.parseInt(st.nextToken());
                students.add(new Student(i, score));
            }
        }

        Collections.sort(students);

        int start = 0, end = 0;
        int count = 0;
        int result = Integer.MAX_VALUE;

        int[] cnt = new int[N];

        while(true){
            if(count >= N){
                Student s = students.get(start++);

                result = Math.min(result, students.get(end-1).score - s.score);                
                
                cnt[s.n]--;
                if(cnt[s.n] == 0) count--;
            }else if(end >= students.size()){
                break;
            }else{
                Student s = students.get(end++);
                if(cnt[s.n] == 0) count++;
                cnt[s.n]++;
            }
        }

        bw.write(result + "\n");
        bw.flush();

    }
}
