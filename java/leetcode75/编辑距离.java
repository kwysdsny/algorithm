package leetcode75;


/***
 * 前i，j个字符,状态转移方程比较难
 */
public class 编辑距离 {
    public static void main(String[] args) {
        minDistance("park","spake");
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <=word1.length() ; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] =1+Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]-1));
                }
                else {
                    dp[i][j] =1+ Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
