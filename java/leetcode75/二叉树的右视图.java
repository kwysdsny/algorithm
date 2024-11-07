package leetcode75;

import java.util.*;

public class 二叉树的右视图 {
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

    /**
     * 广度优先遍历固定写法模板
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        // 用一个 HashMap 来记录每一层的最右节点的值
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        // 记录二叉树的最大深度
        int max_depth = -1;

        // 使用两个队列来进行广度优先遍历（BFS）
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        // 将根节点和其深度（0）加入队列
        nodeQueue.add(root);
        depthQueue.add(0);

        // 进行 BFS，直到队列为空
        while (!nodeQueue.isEmpty()) {
            // 取出当前节点和其深度
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            // 如果当前节点不为空，处理该节点
            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 每次遍历到某一层时，更新该层最右侧的节点的值
                rightmostValueAtDepth.put(depth, node.val);

                // 将当前节点的左子节点和右子节点加入队列，并将其深度增加1
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }

        // 创建一个列表来保存从上到下每一层的最右侧节点的值
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            // 遍历从深度0到最大深度，取出对应深度的最右侧节点的值
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        // 返回右视图列表
        return rightView;
    }

}
