import java.util.*;

public class Insertion {
    static int N;
    static int[] shift;

    static class Node{
        private static Random random = new Random();

        int value;
        int prior;
        int size;
        Node right;
        Node left;

        Node(int value){
            this.size = 1;
            this.prior = random.nextInt();
            this.value = value;
        }

        void setLeft(Node node){    
            left = node;
            calcSize();
        }

        void setRight(Node node){    
            right = node;
            calcSize();
        }

        void calcSize(){
            size = 1;
            if(left != null) size += left.size;
            if(right != null) size += right.size;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            N = sc.nextInt();
            shift = new int[N];
            for(int i=0; i<N; i++){
                shift[i] = sc.nextInt();
            }
            
            solve();
        }
        

        sc.close();
    }

    static void solve(){
        Node candidates = null;

        for(int i=0; i<N; i++){
            candidates = insert(candidates, new Node(i+1));
        }
        int A[] = new int[N];
        for(int i=N-1; i>=0; i--){
            int larger = shift[i];
            Node kth = kth(candidates, i + 1 - larger);
            A[i] = kth.value;
            candidates = erase(candidates, kth.value);
        }

        for(int i=0; i<N; i++){
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    static Node insert(Node root, Node node){
        if(root == null) return node;
        if(node.prior > root.prior){
            Node[] splitted = split(root, node.value);
            node.setLeft(splitted[0]);
            node.setRight(splitted[1]);
            return node;
        }else if(node.value > root.value){
            root.setRight(insert(root.right, node));
        }else {
            root.setLeft(insert(root.left, node));
        }

        return root;
    }

    static Node[] split(Node root, int value){
        if(root == null) return new Node[]{null, null};

        if(root.value > value){
            Node[] rs = split(root.left, value);
            root.setLeft(rs[1]);
            return new Node[]{rs[0], root};
        }
        Node[] rs = split(root.right, value);
        root.setRight(rs[0]);
        return new Node[]{root, rs[1]};
    }

    static Node merge(Node a, Node b){
        if(a == null) return b;
        if(b == null) return a;
        if(a.prior > b.prior){
            a.setRight(merge(a.right, b));
            return a;
        }
        b.setLeft(merge(a, b.left));
        return b;
    }

    static Node erase(Node root, int value){
        if(root == null) return root;
        if(root.value == value){
            Node ret = merge(root.left, root.right);
            return ret;
        }

        if(value < root.value){
            root.setLeft(erase(root.left, value));
        }else{
            root.setRight(erase(root.right, value));
        }

        return root;
    }

    static Node kth(Node root, int k){
        int leftSize = 0;
        if(root.left != null) leftSize = root.left.size;
        if(k <= leftSize) return kth(root.left, k);
        if(k == leftSize + 1) return root;
        return kth(root.right, k-leftSize-1);
    }
}
