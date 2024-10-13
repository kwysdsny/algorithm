package leetcode75;

/**
 * 滑动窗口
 *
 */
public class 最大连续1的个数III {
    public static void main(String[] args) {
int [] a= {1,1,1,0,0,0,1,1,1,1,0};
longestOnes(a,2);
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int currentk=0;
        while (right < nums.length) {
            if (currentk!=k&&nums[right] == 0) {
                currentk++;
                res = Math.max(res, right-left+1);
                right++;

            }
            else if(nums[right]==1) {
                res = Math.max(res, right-left+1);
                right++;
            }
            else if(currentk==k) {
                res = Math.max(res, right-left);
                if(nums[left]==0) {
                    currentk--;
                }
                left++;
            }
        }
        return res;
    }
}
