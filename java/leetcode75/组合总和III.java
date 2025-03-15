package leetcode75;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    static List<Integer> temp = new ArrayList<Integer>();
    static List<List<Integer>>  ans = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        combinationSum3(3,9);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 9, k, n);
        return ans;
    }

    public static void dfs(int cur, int n, int k, int sum) {
        if (temp.size() + (n - cur + 1) < k || temp.size() > k) {
            return;
        }
        if (temp.size() == k) {
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;
            }
            if (tempSum == sum) {
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        temp.add(cur);
        dfs(cur + 1, n, k, sum);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k, sum);
    }
}
