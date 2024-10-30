package leetcode75;

public class 路径总和III {
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
     * 递归中的递归，分主递归和函数递归
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res=dfs(root, targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;


    }

    /**
     * 先序遍历
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int dfs(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) return 0;
        if (root.val == targetSum) {
            res++;
        }
        res+=dfs(root.left, targetSum - root.val);
        res+=dfs(root.right, targetSum - root.val);
        return res;

    }
}
