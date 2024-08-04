import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Tree root;
    static List<Tree> treeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int firstTop = Integer.parseInt(br.readLine());
        root = new Tree(firstTop);

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) break; // Skip empty lines
            int now = Integer.parseInt(line);
            insert(root, now);
        }

        postorderTraversal(root);

    }

    public static void insert(Tree node, int value) {
        if (value < node.top) {
            if (node.left == null) {
                node.left = new Tree(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Tree(value);
            } else {
                insert(node.right, value);
            }
        }
    }


    public static void postorderTraversal(Tree node){
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.top);

    }

    static public class Tree {
        private int top;
        private Tree left;
        private Tree right;

        Tree(int top){
            this.top = top;
            this.left = null;
            this.right = null;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public Tree getLeft() {
            return left;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public Tree getRight() {
            return right;
        }

        public void setRight(Tree right) {
            this.right = right;
        }


        public Tree getPreviousTree(){
            for(Tree t : treeList){
                if(t.getTop() == this.top){
                    return t;
                }
            }
            return null;
        }
    }
}