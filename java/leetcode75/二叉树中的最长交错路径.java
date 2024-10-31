package leetcode75;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 二叉树中的最长交错路径 {
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

    // f和g分别用来存储以每个节点为起点的最长zigzag路径长度
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();
    // 使用队列来进行广度优先遍历
    Queue<TreeNode[]> q = new LinkedList<TreeNode[]>();

    /**
     * 动态规划dp和bfs
     *
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        // 调用dp方法以初始化f和g
        dp(root);
        int maxAns = 0; // 用于记录最长zigzag路径的长度
        // 遍历每个节点的f和g值，找出最大值
        for (TreeNode u : f.keySet()) {
            maxAns = Math.max(maxAns, Math.max(f.get(u), g.get(u)));
        }
        return maxAns; // 返回最长zigzag路径的长度
    }

    public void dp(TreeNode o) {
        // 初始化当前节点o的f和g值为0
        f.put(o, 0);
        g.put(o, 0);
        // 将当前节点和它的父节点（初始为null）放入队列
        q.offer(new TreeNode[]{o, null});
        // 开始广度优先遍历
        while (!q.isEmpty()) {
            TreeNode[] y = q.poll(); // 从队列中取出一个节点及其父节点
            TreeNode u = y[0], x = y[1]; // u为当前节点，x为父节点
            f.put(u, 0); // 初始化当前节点的f值
            g.put(u, 0); // 初始化当前节点的g值
            // 根据父节点的方向更新当前节点的f或g值
            if (x != null) {
                // 如果当前节点是父节点的左子节点
                if (x.left == u) {
                    f.put(u, g.get(x) + 1); // 当前节点的f值为父节点g值加1
                }
                // 如果当前节点是父节点的右子节点
                if (x.right == u) {
                    g.put(u, f.get(x) + 1); // 当前节点的g值为父节点f值加1
                }
            }
            // 如果当前节点有左子节点，将其及当前节点放入队列
            if (u.left != null) {
                q.offer(new TreeNode[]{u.left, u});
            }
            // 如果当前节点有右子节点，将其及当前节点放入队列
            if (u.right != null) {
                q.offer(new TreeNode[]{u.right, u});
            }
        }
    }


    int maxAns;

    /**
     * 递归dfs方法，false向左，true向右
     * @param root
     * @return
     */
    public int longestZigZag2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAns = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxAns;
    }

    public void dfs(TreeNode o, boolean dir, int len) {
        maxAns = Math.max(maxAns, len);
        if (!dir) {
            if (o.left != null) {
                dfs(o.left, true, len + 1);
            }
            if (o.right != null) {
                dfs(o.right, false, 1);
            }
        } else {
            if (o.right != null) {
                dfs(o.right, false, len + 1);
            }
            if (o.left != null) {
                dfs(o.left, true, 1);
            }
        }
    }

}
