package leetcode75;

public class 使用最小花费爬楼梯 {
    /**
     * 求sum
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int sum = 0;
        int[] mincost = new int[cost.length+1];
        mincost[0] = 0;
        mincost[1] = 0;
        //10,15,20,25
        for (int i = 2; i <=cost.length; i++) {
            int a=mincost[i-2]+cost[i-2];
            int b=mincost[i-1]+cost[i-1];
            mincost[i] = Math.min(a,b);
        }
        return mincost[cost.length];
    }
}
