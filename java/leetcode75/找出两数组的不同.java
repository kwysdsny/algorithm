package leetcode75;

import java.util.*;

public class 找出两数组的不同 {
    public static void main(String[] args) {

    }

    /**
     * 转为哈希集合，并对两集合遍历判断
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // 创建一个列表用于存储最终的结果，包含两个列表
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>()); // 用于存储 nums1 中有但 nums2 中没有的元素
        answer.add(new ArrayList<>()); // 用于存储 nums2 中有但 nums1 中没有的元素

        // 创建两个集合用于快速判断元素是否存在
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        // 将 nums1 中的元素加入集合 s1
        for (int num : nums1) s1.add(num);
        // 将 nums2 中的元素加入集合 s2
        for (int num : nums2) s2.add(num);

        // 查找在 s1 中但不在 s2 中的元素
        search(s1, s2, 0, answer);
        // 查找在 s2 中但不在 s1 中的元素
        search(s2, s1, 1, answer);

        // 返回包含两部分差异的结果
        return answer;
    }

    // 辅助方法，用于查找集合 s1 中不在 s2 中的元素
    private void search(Set<Integer> s1, Set<Integer> s2, int idx, List<List<Integer>> answer) {
        for (int num : s1) { // 遍历集合 s1 的每个元素
            if (!s2.contains(num)) { // 如果 s2 不包含该元素
                answer.get(idx).add(num); // 将该元素添加到对应的答案列表中
            }
        }
    }



}
