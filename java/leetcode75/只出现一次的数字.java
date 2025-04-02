package leetcode75;

/**
 * 异或运算求
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
