package leetcode75;

public class 字符串的最大公因子 {
    public static void main(String[] args) {

    }
    public static String gcdOfStrings(String str1, String str2) {
        // 检查 str1 和 str2 的连接是否相等于 str2 和 str1 的连接
        // 如果不相等，则说明这两个字符串没有相同的重复模式
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            // 如果不相等，返回空字符串
            return "";
        }
        // 否则，返回 str1 的前 gcd(str1.length(), str2.length()) 个字符
        // gcd 是计算两个字符串长度的最大公约数
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        // 计算 a 和 b 的最大公约数（Greatest Common Divisor）
        while (b != 0) {
            // 使用欧几里得算法计算最大公约数
            int temp = b;       // 将 b 存储在临时变量中
            b = a % b;          // 更新 b 为 a 除以 b 的余数
            a = temp;           // 更新 a 为之前的 b
        }
        // 返回最大公约数（即最终的 a）
        return a;
    }

}
