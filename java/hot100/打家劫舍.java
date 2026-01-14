package hot100;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int[] maxmoney = new int[nums.length];
        maxmoney[0] = nums[0];
        if(nums.length == 1) return maxmoney[0];
        maxmoney[1] = Math.max(nums[0], nums[1]);
        /**
         * 2,7,9,3,1
         */
        for (int i = 2; i <maxmoney.length; i++) {
            maxmoney[i] = Math.max(maxmoney[i-2] + nums[i], maxmoney[i-1]);

        }
        return maxmoney[nums.length-1];
    }
}
