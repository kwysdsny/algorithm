package leetcode75;

import java.util.*;

public class 最大层内元素和 {
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
     * 广度优先遍历固定写法模板2
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;  // 如果根节点为空，直接返回0
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        queue.offer(root);
        depth.offer(1);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = depth.poll();

            if (node != null) {  // 只有非 null 节点才处理
                map.put(level, map.getOrDefault(level, 0) + node.val);

                // 只在节点非空时将子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                    depth.offer(level + 1);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    depth.offer(level + 1);
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int smallestKey = Integer.MAX_VALUE;

        // 遍历 map 找到最大值对应的最小层
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                smallestKey = key;
            } else if (value == maxValue) {
                smallestKey = Math.min(smallestKey, key);
            }
        }

        return smallestKey;
    }

}
