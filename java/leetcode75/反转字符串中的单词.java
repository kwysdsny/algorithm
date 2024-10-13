package leetcode75;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class 反转字符串中的单词 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

        public static String reverseWords(String s) {
            // 除去开头和末尾的空白字符
            s = s.trim();
            // 正则匹配连续的空白字符作为分隔符分割
            List<String> wordList = Arrays.asList(s.split("\\s+"));
            Collections.reverse(wordList);
            return String.join(" ", wordList);
        }

    //字符串数组转换为集合，Arrays.asList(array);
    //字符串数组转换为集合，List<String> list = List.of(array);可能需要包装类
}
