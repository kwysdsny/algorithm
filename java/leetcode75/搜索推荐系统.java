package leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 搜索推荐系统 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            res.add(search(searchWord.substring(0, i), products));
        }
        return res;
    }

    public List<String> search(String w, String[] arr) {
        int lo = findLower(w, arr);
        List<String> res = new ArrayList<>();
        while (lo < arr.length && res.size() < 3 && arr[lo].startsWith(w)) {
            res.add(arr[lo++]);
        }
        return res;
    }

    public int findLower(String w, String[] arr) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cmp = arr[mid].compareTo(w);
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
