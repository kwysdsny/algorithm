package leetcode75;

public class 统计二叉树中好节点的数目 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历dfs将问题分割成根节点，左子树和右子树
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        int pathmax = Integer.MIN_VALUE;
        return dfs(root, pathmax);
    }

    private int dfs(TreeNode root, int pathmax) {
        int res = 0;
        if (root == null) return 0;
        if (root.val >= pathmax) {
            res++;
            pathmax = root.val;
        }
        res += dfs(root.left, pathmax);
        res += dfs(root.right, pathmax);
        return res;
    }
}
