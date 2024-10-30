package leetcode75;

public class 树的深度优先遍历 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    /**
     * 先序遍历
     * @param root
     */
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " "); // 访问根节点
        preOrder(root.left);               // 递归左子树
        preOrder(root.right);              // 递归右子树
    }

    /**
     * 中序遍历
     * @param root
     */
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);                // 递归左子树
        System.out.print(root.val + " "); // 访问根节点
        inOrder(root.right);               // 递归右子树
    }

    /**
     * 后序遍历
     * @param root
     */
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);              // 递归左子树
        postOrder(root.right);             // 递归右子树
        System.out.print(root.val + " "); // 访问根节点
    }

}
