import java.util.*;

public class Traversal {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            int n = sc.nextInt();
            List<Integer> preOrder = new ArrayList<>();
            List<Integer> inOrder = new ArrayList<>();

            for(int i=0; i<n; i++){
                preOrder.add(sc.nextInt());
            }

            for(int i=0; i<n; i++){
                inOrder.add(sc.nextInt());
            }
            
            postOrder(preOrder, inOrder);
            System.out.println();
        }

        sc.close();
    }

    static void postOrder(List<Integer> preOrder, List<Integer> inOrder){
        int n = preOrder.size();

        if(preOrder.isEmpty()) return;

        int root = preOrder.get(0);

        int idx = inOrder.indexOf(root);

        postOrder(preOrder.subList(1, idx+1), inOrder.subList(0, idx));
        postOrder(preOrder.subList(idx+1, n), inOrder.subList(idx+1, n));
        
        System.out.print(root + " ");
    }
    
}
