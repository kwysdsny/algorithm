package hot100;

public class 路径总和III {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int res=dfs(root, targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }
    public int dfs(TreeNode root, long targetSum){
        if (root == null) return 0;
        int res=0;
        if (root.val == targetSum) res++;
        res+=dfs(root.left,targetSum-root.val);
        res+=dfs(root.right,targetSum-root.val);
        return res;
    }
}
