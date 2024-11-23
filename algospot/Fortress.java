import java.util.*;

public class Fortress {
    static int maxHeight;
    static List<Node> nodes;


    static class Node {
        List<Node> childs = new ArrayList<>();

        int x, y, r;
        boolean isContains = false;

        boolean contains(Node node){
            // 현재 r > 두 점 사이 거리 + node의 r 
            int xDif = Math.abs(x - node.x);
            int yDif = Math.abs(y - node.y);

            double dist = Math.sqrt(Math.pow(xDif, 2) + Math.pow(yDif, 2));

            return r > dist + node.r;
        }

        Node(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public static Node of(int x, int y, int r){
            return new Node(x, y, r);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        while(C-- > 0){
            maxHeight = 0;

            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            
            Node root = Node.of(x,y,r);
            nodes = new ArrayList<>();

            for(int i=1; i<N; i++){
                x = sc.nextInt();
                y = sc.nextInt();
                r = sc.nextInt();
                nodes.add(Node.of(x, y, r));
            }
            nodes.sort((n1, n2) -> n2.r - n1.r);
            
            insert(root);

            maxHeight = Math.max(solve(root), maxHeight);
            System.out.println(maxHeight);
        }

        sc.close();
    }

    public static void insert(Node root){
        for(Node node : nodes){
            if(node.isContains) continue;
            if(root.contains(node)){
                insert(node);
                root.childs.add(node);
                node.isContains = true;
            }
        }
    }

    static int solve(Node root){
        List<Node> childs = root.childs;

        if(childs.isEmpty()) return 0;

        List<Integer> heights = new ArrayList<>();

        for(Node child : childs){
            heights.add(solve(child));
        }

        Collections.sort(heights);

        if(heights.size() >= 2){
            maxHeight = Math.max(maxHeight, 2 + heights.get(heights.size() - 1) + heights.get(heights.size() - 2));
        }

        return heights.get(heights.size() - 1) + 1;
    }

    
}
