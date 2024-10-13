package hot100;

import java.util.*;

public class 字母异位词分组 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个 HashMap，用于存储排序后的字符串作为键，对应的原始字符串列表作为值
        Map<String, List<String>> map = new HashMap<>();

        // 遍历每一个字符串
        for (String s : strs) {
            // 将字符串转换成字符数组
            char[] chars = s.toCharArray();

            // 对字符数组进行排序
            Arrays.sort(chars);

            // 将排序后的字符数组转换成字符串，作为 HashMap 的键
            String key = new String(chars);

            // 从 HashMap 中获取以该键对应的列表，如果不存在则创建一个新的 ArrayList
            List<String> list = map.getOrDefault(key, new ArrayList<>());

            // 将原始字符串添加到列表中
            list.add(s);

            // 将更新后的列表放回 HashMap 中
            map.put(key, list);
        }

        // 返回 HashMap 中所有的值，即分组后的字符串列表
        return new ArrayList<>(map.values());
    }

}
