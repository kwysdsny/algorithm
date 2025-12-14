package hot100;

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
     * 二叉树的右视图 使用栈时接口为Deque，实现类为LinkedList和ArrayDeque
     * 栈的方法：
     * push()：将元素添加到栈的顶部
     * pop()：移除栈的顶部元素
     * peek()：返回栈的顶部元素
     * @param root
     * @return
     */
    public List<Integer> rightSideViewDfsStack(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
        Deque<Integer> depthStack = new LinkedList<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }



    /**
     * 二叉树的右视图 使用队列时接口为Queue，实现类为LinkedList和ArrayDeque
     * 队列的方法：
     * add()：将元素添加到队列的末尾，如果队列已满，则抛出IllegalStateException异常
     * offer()：将元素添加到队列的末尾，如果队列已满，则返回false
     * remove()：移除队列的头元素，如果队列为空，则抛出NoSuchElementException异常
     * poll()：移除队列的头元素，如果队列为空，则返回null
     * element()：返回队列的头元素，如果队列为空，则抛出NoSuchElementException异常
     * peek()：返回队列的头元素，如果队列为空，则返回null
     * @param root
     * @return
     */
    public List<Integer> rightSideViewBfsQueue(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

}
