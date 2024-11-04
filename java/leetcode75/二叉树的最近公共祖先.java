package leetcode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 二叉树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归，如果左边没找到，抛出右边的值到更上一层，右边同理
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，或者当前节点是 p 或 q，返回当前节点
        if (root == null || root == p || root == q) return root;

        // 递归查找 p 和 q 在左子树中的最低公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 递归查找 p 和 q 在右子树中的最低公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左子树没有找到 p 或 q，则返回右子树的结果
        if (left == null) return right;

        // 如果右子树没有找到 p 或 q，则返回左子树的结果
        if (right == null) return left;

        // 如果左右子树都找到了 p 或 q，当前节点是最低公共祖先，返回当前节点
        return root;
    }

    // 用于存储每个节点的父节点
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    // 用于存储已访问的节点值
    Set<Integer> visited = new HashSet<Integer>();

    // 深度优先搜索 (DFS) 方法，用于记录每个节点的父节点
    public void dfs(TreeNode root) {
        // 如果左子节点不为空，将其父节点存入 parent 映射
        if (root.left != null) {
            parent.put(root.left.val, root);
            // 递归遍历左子树
            dfs(root.left);
        }
        // 如果右子节点不为空，将其父节点存入 parent 映射
        if (root.right != null) {
            parent.put(root.right.val, root);
            // 递归遍历右子树
            dfs(root.right);
        }
    }

    // 查找两个节点 p 和 q 的最低公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 通过 DFS 填充 parent 映射
        dfs(root);

        // 从节点 p 开始，沿着父节点链向上遍历，记录访问的节点
        while (p != null) {
            visited.add(p.val); // 将节点 p 的值添加到 visited 集合中
            p = parent.get(p.val); // 向上移动到父节点
        }

        // 从节点 q 开始，沿着父节点链向上遍历，查找第一个已访问的节点
        while (q != null) {
            // 如果 visited 集合中包含节点 q 的值，返回节点 q
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val); // 向上移动到父节点
        }
        // 如果没有找到公共祖先，返回 null
        return null;
    }


}
