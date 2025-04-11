package hot100;

import java.util.*;

public class 合并区间 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged= new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.isEmpty()||merged.get(merged.size()-1)[1] < L)
                merged.add(intervals[i]);
            else
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], R);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
