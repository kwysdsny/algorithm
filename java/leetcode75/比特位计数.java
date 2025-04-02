package leetcode75;


/**
 *
 */
public class 比特位计数 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    /**
     * “布莱恩·克尼根算法”（Brian Kernighan's algorithm）
     * @param x
     * @return
     */
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
