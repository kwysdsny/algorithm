package leetcode75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 雇佣K位工人的总代价 {
    public static void main(String[] args) {
        int[] costs=new int[]{17,12,10,2,7,2,11,20,8};
        totalCost(costs,3,4);
    }
    public static long totalCost(int[] costs, int k, int candidates) {
        // 创建 PriorityQueue，并传入自定义比较器
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 按照数组的第 0 位从小到大排序
                return Integer.compare(a[0], b[0]);
            }
        });
        if (candidates * 2 < costs.length) {
            for (int i = 0; i < candidates; i++) {
                int[] temp = new int[]{costs[i], -1};
                pq.add(temp);
                int[] temp2 = new int[]{costs[costs.length - i - 1], 1};
                pq.add(temp2);
            }
        } else {
            long sum = 0;
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                sum += costs[i];

            }
            return sum;
        }
        int i = 1;
        long sum = 0;
        int left = candidates - 1;
        int right = costs.length - candidates;
        int jilu = 0;
        do {
            int[] temp = pq.poll();
            sum += temp[0];
            if (temp[1] == -1) {
                left++;
                jilu++;
                if (candidates * 2 + jilu <= costs.length) {
                    int[] temp2 = new int[]{costs[left], -1};
                    pq.add(temp2);
                }
            } else {
                right--;
                jilu++;
                if (candidates * 2 + jilu <= costs.length) {
                    int[] temp2 = new int[]{costs[right], 1};
                    pq.add(temp2);
                }
            }
            i++;
        } while (i <= k);
        return sum;
    }
}
