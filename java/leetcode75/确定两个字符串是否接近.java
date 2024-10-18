package leetcode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 确定两个字符串是否接近 {
    public boolean closeStrings(String word1, String word2) {
        // 创建两个长度为26的数组，用于统计每个字母（a-z）的出现次数
        int[] char1 = new int[26];
        int[] char2 = new int[26];

        // 将字符串转为字符数组
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        // 遍历第一个字符数组，统计每个字符的出现次数
        for (int i = 0; i < charArray1.length; i++) {
            char1[charArray1[i] - 'a']++; // 根据字符的ASCII值计算索引
        }

        // 遍历第二个字符数组，统计每个字符的出现次数
        for (int i = 0; i < charArray2.length; i++) {
            char2[charArray2[i] - 'a']++; // 根据字符的ASCII值计算索引
        }

        // 检查两个字符数组是否具有相同的字符
        for (int i = 0; i < 26; i++) {
            // 如果某个字符在一个数组中出现而在另一个数组中没有出现，返回false
            if (!(char1[i] > 0 && char2[i] > 0 || char1[i] == 0 && char2[i] == 0)) {
                return false; // 不符合条件
            }
        }

        // 对两个字符出现次数的数组进行排序
        Arrays.sort(char1);
        Arrays.sort(char2);

        // 比较两个字符出现次数的数组
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) { // 如果某个字符的出现次数不一致，返回false
                return false;
            }
        }

        // 如果通过所有检查，返回true，表示两个字符串可以转换为相同的字母组合
        return true;
    }

}

