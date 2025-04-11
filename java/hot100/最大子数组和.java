package hot100;

public class 最大子数组和 {
    public static void main(String[] args) {
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(a);
    }
    public static int maxSubArray(int[] nums) {
        int pre=0,max=nums[0];
        for(int i=0;i<nums.length;i++){
            pre=Math.max(nums[i],pre+nums[i]);
            max=Math.max(max,pre);
        }
        return max;
    }
}
