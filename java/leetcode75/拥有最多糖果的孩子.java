package leetcode75;

import java.util.ArrayList;
import java.util.List;

public class 拥有最多糖果的孩子 {
    public static void main(String[] args) {

    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> result = new ArrayList<>();
        int max = findMax(candies);
        for (int i = 0; i < n; i++) {
            if (candies[i]+extraCandies >= max) {
                result.add(true);
            }
            else
                result.add(false);
        }
        return result;
    }
    public static int findMax(int[] array) {
        int max = array[0]; // 假设第一个元素是最大值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // 更新最大值
                //int max = Math.max(max, array[i]); 使用函数运行时间变慢
            }
        }
        return max;
    }
}
