package leetcode75;

import java.util.*;

public class 电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int n = digits.length();
        if (n == 0){
            return result;
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
        result = map.get(digits.charAt(0));
        if (n == 1){
            return result;
        }
        int i = 1;
        while (i < n){
            List<String> temp = new ArrayList<>();
            for (String s1 : result) {
                for (String s2 : map.get(digits.charAt(i))) {
                    temp.add(s1+s2);
                }
            }
            result = temp;
            i++;
        }
        return result;
    }
}
