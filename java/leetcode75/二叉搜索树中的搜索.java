package leetcode75;

public class 二叉搜索树中的搜索 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root!=null&&root.val>val)
            return searchBST(root.left,val);
        else if(root!=null&&root.val<val)
            return searchBST(root.right,val);
        return root;
    }
}
