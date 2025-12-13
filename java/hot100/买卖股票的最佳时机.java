package hot100;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int max=0;
        int mai=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[mai]){
                max=Math.max(max,prices[i]-prices[mai]);
            }else{
                mai=i;
            }
        }
        return max;
    }
}
