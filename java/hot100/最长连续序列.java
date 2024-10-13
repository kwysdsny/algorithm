package hot100;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[] a = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(a));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); // 创建一个集合来存储数组中的唯一数字
        for (int num : nums) {
            set.add(num); // 将数组中的每个数字添加到集合中
        }
        int maxlength = 0; // 用于记录最长的连续序列的长度
        for (int num : set) {
            // 如果当前数字不是任何序列的延续（即它是序列的起始点）
            if (!set.contains(num - 1)) {
                int currentlength = 1; // 当前序列的长度，从1开始
                int currentnum = num; // 当前数字
                // 扩展序列，直到找不到连续的数字
                while (set.contains(currentnum + 1)) {
                    currentnum++; // 继续到下一个数字
                    currentlength++; // 序列长度增加
                }
                // 更新最长的连续序列长度
                maxlength = Math.max(maxlength, currentlength);
            }
        }
        return maxlength; // 返回最长连续序列的长度

    }
}
