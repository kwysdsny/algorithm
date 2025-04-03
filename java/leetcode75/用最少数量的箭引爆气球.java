package leetcode75;

import java.util.Arrays;
import java.util.Comparator;

public class 用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        int[][] nums = {{-2147483646,-2147483645},{2147483646,2147483647}};
        findMinArrowShots(nums);
    }
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int count = 1;
        int right = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > right){
                right = points[i][1];
                count++;
            }
        }
        return count;
    }
    
}
