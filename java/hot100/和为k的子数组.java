package hot100;

import java.util.HashMap;

public class 和为k的子数组 {
    public static void main(String[] args) {
        int[] a={1,1,1};
        subarraySum1(a,2);
    }
    /**
     * 枚举法
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和+哈希表优化,哈希表存储元素和出现次数，并在当前循环中通过哈希表查找有多少前缀和满足条件
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
