package leetcode75;

public class 寻找数组的中心下标 {
    public static void main(String[] args) {

    }
    public int pivotIndex(int[] nums) {
        int sumleft=0;
        int sumright=0;
        for(int i=0;i<nums.length;i++){
            sumright+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(i>0) sumleft+=nums[i-1];
            sumright=sumright-nums[i];
            if(sumleft==sumright){
                return i;
            }
        }
        return -1;
    }
}
