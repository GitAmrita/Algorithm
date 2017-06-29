package SortingAndSearching;

/**
 * Created by amritachowdhury on 6/27/17.
 */
public class coding_10_10 {
    BST root = null;
    public class BST {
        int data, left_size;
        BST left;
        BST right;

        public BST(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.left_size = 0;
        }

        public void insert(int d) {
            if (d <= this.data) {
                if (this.left != null) {
                    left.insert(d);
                } else {
                    left = new BST(d);
                }
                left_size++;
            } else {
                if (this.right != null) {
                    right.insert(d);
                } else {
                    right = new BST(d);
                }
            }
        }

        public int getRank(int d) {
            if ( d == data) {
                return left_size;
            } else if (d < data) {
                return left == null ? -1 : left.getRank(d);
            } else {
                int rightRank = right == null ? -1 : right.getRank(d);
                return rightRank == -1 ? -1 : left_size + rightRank + 1;
            }
        }
    }

    private void track(int data) {
        if (root == null) {
            root = new BST (data);
        } else {
            root.insert(data);
        }
    }

    private int getRank(int data) {
        return root.getRank(data);
    }

    public void run() {
        track(5); track(1); track(4); track(4); track(5); track(9); track(7);
        track(13); track(3);
        int j = getRank(1);
        System.out.println(j);
        j = getRank(3);
        System.out.println(j);
        j = getRank(4);
        System.out.println(j);
    }
}
