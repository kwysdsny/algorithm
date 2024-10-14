package leetcode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 独一无二的出现次数 {
    public static void main(String[] args) {

    }
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        //定义键值为Integer，后续不需要将object强转为Integer



        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);

        }
        Set<Integer> set =new HashSet<>();

        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            set.add(entry.getValue());
        }
        //hashMap.forEach((k,v)->set.add(v));


        return set.size() == hashMap.size();
    }
}
