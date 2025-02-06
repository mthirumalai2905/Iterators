import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    private List<Integer> nodes;
    private int idx;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        idx = -1;
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        nodes.add(root.val);
        inorderTraversal(root.right);
    }

    public boolean hasNext() {
        return idx + 1 < nodes.size();
    }

    public int next() {
        return nodes.get(++idx);
    }

    public boolean hasPrev() {
        return idx > 0;
    }

    public int prev() {
        return nodes.get(--idx);
    }
}
