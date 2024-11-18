import java.util.*;

public class Brackets2 {
    static final List<Character> openBrackets = Arrays.asList('{', '(', '[');

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        sc.nextLine();
        
        while(C-- > 0){
            
            String brackets = sc.nextLine();
            solve(brackets);
        }
        
        sc.close();
    }

    static void solve(String brackets){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<brackets.length(); i++){
            char bracket = brackets.charAt(i);

            if(openBrackets.contains(bracket)){
                st.push(bracket);
            }else{
                if(st.empty()) {
                    System.out.println("NO");
                    return;
                }

                char gottenBracket = st.pop();
                if(bracket == ')' && gottenBracket == '(') continue;
                if(bracket == ']' && gottenBracket == '[') continue;
                if(bracket == '}' && gottenBracket == '{') continue;

                System.out.println("NO");
                return;
            }
        }

        if(st.empty()) System.out.println("YES");
        else System.out.println("NO");
    }
    
}
