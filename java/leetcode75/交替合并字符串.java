package leetcode75;

public class 交替合并字符串 {
    // 主方法，接受两个字符串 word1 和 word2 作为输入，返回它们交替合并后的结果
    public String mergeAlternately(String word1, String word2) {
        // 获取两个字符串的长度
        int m = word1.length(), n = word2.length();
        // 初始化两个指针 i 和 j 用于遍历两个字符串
        int i = 0, j = 0;

        // 使用 StringBuilder 来构建结果字符串
        StringBuilder ans = new StringBuilder();
//        String ans=new String();
        // 遍历直到两个字符串都被完全遍历
        while (i < m || j < n) {
            // 如果 word1 还有未遍历的字符，则将其添加到结果中
            if (i < m) {
                ans.append(word1.charAt(i));
                ++i; // 移动指针 i 到下一个字符
            }
            // 如果 word2 还有未遍历的字符，则将其添加到结果中
            if (j < n) {
                ans.append(word2.charAt(j));
                ++j; // 移动指针 j 到下一个字符
            }
        }
        // 返回构建好的结果字符串
        return ans.toString();
    }
}
