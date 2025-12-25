package hot100;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, List<Integer> path) {
        // 结束条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历选择列表
        for (int i = 0; i < nums.length; i++) {
            // 剪枝：已经用过的数不能再用
            if (used[i]) continue;

            // 做选择
            used[i] = true;
            path.add(nums[i]);

            // 递归
            backtrack(nums, path);

            // 撤销选择
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
