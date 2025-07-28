package hot100;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  list=new ArrayList<>();
        visit(root,list);
        return list;
    }
    public void visit(TreeNode root,List list){
        if(root==null) return;
        visit(root.left,list);
        list.add(root.val);
        visit(root.right,list);
    }
}
