package leetcode75;

public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i!=0&&i!= nums.length-1&&nums[i] > nums[i + 1]&&nums[i]>nums[i-1]) {
                return i;
            }
            else if (i==0&&i!= nums.length-1&&nums[i] > nums[i + 1]) {
                return i;
            }
            else if (i!=0&&i== nums.length-1&&nums[i] > nums[i - 1]) {
                return i;
            }

        }
        return 0;
    }
}
