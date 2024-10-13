package leetcode75;

public class 删掉一个元素以后全为1的最长子数组 {
    public static void main(String[] args) {
        int[] a={1,1,0,1};
        longestSubarray(a);
    }

    /**
     * 双指针滑动窗口
     * @param nums
     * @return
     */
    public static int longestSubarray(int[] nums) {
        int i=0,j=0;
        int res=0;
        int currentres=0;
        int currentdelete=0;
        int index0=-1;
        while(j<nums.length){
            if(nums[j]==1){
                currentres=j-i+1;
                j++;
            }
            else{
                if(currentdelete==1){
                    res=Math.max(res,currentres);
                    i=index0+1;
                    currentdelete=0;
                    index0=-1;

                }
                else {
                    index0=j;
                    currentdelete++;
                    currentres=j-i+1;
                    j++;

                }
            }
        }
        res=Math.max(res,currentres);
        return res-1;
    }
}
