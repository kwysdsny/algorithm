package leetcode75;

public class 子数组最大平均数1 {
    public static void main(String[] args) {
        int[] a = {5};
        findMaxAverage(a, 1);
    }

    /**
     * 使用暴力循环可能导致超时，注意到对cuurentsum有重复计算部分，所以进行优化，还可以从正负数方面考虑是否计算值
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        // 用于存储当前窗口的长度（始终为k）
        double currentlength = 0;
        // 当前窗口的和
        double currentsum = 0;
        // 存储找到的最大平均值，初始化为最小整数值
        double sumavg = Integer.MIN_VALUE;

        // 窗口的左边界
        int i = 0;
        // 窗口的右边界（初始时为k）
        int j = k;

        // 当右边界j不超过数组长度时继续循环
        while (j <= nums.length) {
            // 如果不是第一次计算（i != 0），更新当前和
            if (i != 0) {
                // 移出左边界的元素，添加右边界的新元素
                currentsum = currentsum - nums[i - 1] + nums[j - 1];
            } else {
                // 第一次计算窗口和，累加前k个元素
                for (int kk = i; kk < j; kk++) {
                    currentsum += nums[kk];
                }
            }

            // 更新最大平均值
            sumavg = Math.max(sumavg, currentsum / k);

            // 移动窗口：左边界向右移动一位
            i++;
            // 右边界向右移动一位
            j++;
        }
        // 返回找到的最大平均值
        return sumavg;
    }
}
