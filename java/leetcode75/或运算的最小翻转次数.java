package leetcode75;

public class 或运算的最小翻转次数 {
    public int minFlips(int a, int b, int c) {
        int count = 0;

        // 遍历每一位
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1; // 获取 a 的第 i 位
            int bitB = (b >> i) & 1; // 获取 b 的第 i 位
            int bitC = (c >> i) & 1; // 获取 c 的第 i 位

            // 如果 c 的某一位是 0，而 a 或 b 的某一位是 1，则需要翻转
            if (bitC == 0) {
                if (bitA == 1) count++;
                if (bitB == 1) count++;
            } else {
                // 如果 c 的某一位是 1，而 a 和 b 的某一位都是 0，则需要翻转一次
                if (bitA == 0 && bitB == 0) count++;
            }
        }

        return count;
    }


}
