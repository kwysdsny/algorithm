package leetcode75;

public class 从字符串中移除星号 {

    public String removeStars(String s) {
        StringBuilder res = new StringBuilder(); // 初始化 StringBuilder 用于构建结果字符串
        for (char c : s.toCharArray()) { // 遍历输入字符串的每个字符
            if (c != '*') { // 如果字符不是星号
                res.append(c); // 将当前字符添加到结果字符串
            } else { // 如果字符是星号
                res.setLength(res.length() - 1); // 删除结果字符串的最后一个字符
            }
        }
        return res.toString(); // 返回最终结果字符串
    }
    

}
