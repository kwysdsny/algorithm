package leetcode75;

import java.util.Arrays;

public class K和数对的最大数目 {
    public static void main(String[] args) {

    }
    public static int maxOperations(int[] nums, int k) {
        // 对数组进行排序，以便使用双指针方法进行配对
        Arrays.sort(nums);

        // 初始化两个指针，i指向数组的开始，j指向数组的结束
        int i = 0, j = nums.length - 1;
        // 用于记录满足条件的配对次数
        int sum = 0;

        // 当左指针小于右指针时，继续寻找配对
        while (i < j) {
            // 如果当前配对的和大于k，右指针向左移动
            if (nums[i] + nums[j] > k) {
                j--;
            }
            // 如果当前配对的和小于k，左指针向右移动
            else if (nums[i] + nums[j] < k) {
                i++;
            }
            // 如果当前配对的和等于k，找到一对，指针均移动
            else {
                i++; // 左指针向右移动
                j--; // 右指针向左移动
                sum++; // 配对次数加1
            }
        }

        // 返回找到的配对次数
        return sum;
    }
}
