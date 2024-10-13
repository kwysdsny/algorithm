package 面试经典150题;

import java.util.*;

/**
 * 滑动窗口
 */
public class 最小覆盖子串 {
    // 创建一个哈希表 ori，用于存储目标字符串 t 中每个字符及其出现次数
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    // 创建一个哈希表 cnt，用于存储当前窗口中字符的计数
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        // 获取目标字符串 t 的长度
        int tLen = t.length();
        // 遍历目标字符串 t，统计每个字符的出现次数并存入 ori
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i); // 获取当前字符
            // 更新 ori 中该字符的计数
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1; // 初始化左右指针
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1; // 初始化最小长度和答案的左右边界
        int sLen = s.length(); // 获取源字符串 s 的长度

        // 开始滑动窗口
        while (r < sLen) {
            ++r; // 右指针向右移动
            // 如果右指针在字符串范围内，并且当前字符在 ori 中
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                // 更新 cnt 中当前字符的计数
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            // 检查当前窗口是否满足包含所有 t 中字符的条件
            while (check() && l <= r) {
                // 如果当前窗口长度小于已有的最小长度，更新最小长度和答案边界
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l; // 更新左边界
                    ansR = l + len; // 更新右边界
                }
                // 如果左指针指向的字符在 ori 中，减少 cnt 中该字符的计数
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l; // 左指针向右移动
            }
        }

        // 返回找到的最小窗口子串，如果没有找到则返回空字符串
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    // 检查当前窗口是否包含所有目标字符
    public boolean check() {
        // 获取 ori 哈希表（Map）的所有键值对的迭代器
        Iterator iter = ori.entrySet().iterator();
        // 遍历每个键值对
        while (iter.hasNext()) {
            // 获取当前键值对
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey(); // 获取当前键（字符）
            Integer val = (Integer) entry.getValue(); // 获取当前值（出现次数）
            // 如果当前窗口中该字符的计数小于所需计数，返回 false
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        // 所有字符都满足条件，返回 true
        return true;
    }


}
