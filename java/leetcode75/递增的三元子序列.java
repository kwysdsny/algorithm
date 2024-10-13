package leetcode75;

public class 递增的三元子序列 {
    public static void main(String[] args) {
        int[] a={20,100,10,12,5,13};
        System.out.println(increasingTriplet(a));
    }
    public static boolean increasingTriplet(int[] nums) {//贪心
        // 初始化第一个数为数组的第一个元素
        int first = nums[0];
        // 初始化第二个数为最大值，用于后续比较
        int second = Integer.MAX_VALUE;

        // 从数组的第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素大于第二个数，则找到了一个递增的三元组
            if (nums[i] > second) {
                return true;
            }
            // 如果当前元素在 first 和 second 之间，更新 second
            else if (nums[i] < second && nums[i] > first) {
                second = nums[i];
            }
            // 如果当前元素小于 first，更新 first
            else if (nums[i] < first) {
                first = nums[i];
            }
        }
        // 如果没有找到递增的三元组，返回 false
        return false;
    }

}
