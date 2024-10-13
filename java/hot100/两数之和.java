package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target=9;
        System.out.println(twoSum(arr, target));
    }
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i< nums.length; i++) {
                if(map.containsKey(target - nums[i])) {//map中是否包含键
                    return new int[] {map.get(target-nums[i]),i};
                }
                map.put(nums[i], i);
            }
             throw new IllegalArgumentException("No two sum solution");
        }
    }

