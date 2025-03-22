package leetcode75;

/**
 * 经典 重点！！！
 * dp[i][j] 表示 text1 的前 i 个字符和 text2 的前 j 个字符的最长公共子序列的长度
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        String text1="abcde";
        String text2="ace";
        longestCommonSubsequence(text1,text2);
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
//        数组默认0值
//        for (int i = 1; i <= m; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 1; j <= n; j++) {
//            dp[0][j] = 0;
//        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
