package hot100;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {
    // 方法功能：传入一个字符串s，返回其「无重复字符的最长子串」的长度
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录【当前窗口内】已经出现过的字符，利用Set的不可重复性快速判断字符是否重复
        Set<Character> occ = new HashSet<Character>();
        // 获取字符串的总长度，后续循环/判断边界都会用到
        int n = s.length();
        // 右指针 rk，初始值为 -1 非常关键：相当于指针在字符串最左侧边界的左边，还未开始扫描任何字符
        int rk = -1, ans = 0;
        // 外层for循环：移动【左指针i】，i是滑动窗口的左边界，逐个位置作为窗口的起始点
        for (int i = 0; i < n; ++i) {
            // 核心细节：i != 0 代表左指针已经向右移动了，不是第一次循环
            if (i != 0) {
                // 左指针向右移动一格，就要把【上一个左边界的字符】从集合中移除
                // 因为该字符已经不在当前的窗口区间[i, rk]内了
                occ.remove(s.charAt(i - 1));
            }
            // 内层while循环：移动【右指针rk】，rk是滑动窗口的右边界，尽可能向右扩张
            // 循环条件：① rk+1 < n 保证右指针不越界 ② 窗口的下一个字符 不在集合中（无重复）
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 满足条件：把下一个字符加入集合，标记为已出现
                occ.add(s.charAt(rk + 1));
                // 右指针向右移动一格，扩大窗口范围
                ++rk;
            }
            // 此时，窗口区间 [i, rk] 是 以i为左边界的「无重复字符的最长子串」（极长子串）
            // 计算当前窗口的长度 (rk - i + 1)，和历史最大值ans比较，保留更大的值
            ans = Math.max(ans, rk - i + 1);
        }
        // 遍历完所有可能的左边界，返回最终的最大长度
        return ans;
    }
}
