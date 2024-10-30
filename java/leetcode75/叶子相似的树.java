package leetcode75;

import java.util.ArrayList;
import java.util.List;

public class 叶子相似的树 {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);
        return list1.equals(list2);

    }
    //使用中序遍历
    public void inOrder(TreeNode root, List<Integer> list) {
          if (root == null) {
              return;
          }
        inOrder(root.left,list);
          if(root.left==null && root.right==null) {
                list.add(root.val);
          }
          inOrder(root.right,list);
    }
}
