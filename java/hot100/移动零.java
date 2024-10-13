package hot100;


/**
 * 双指针将数往前移动，后面补零
 * @author ycp
 */
public class 移动零 {
    public static void main(String[] args) {

    }
    public static void moveZeroes(int[] nums) {
        int b=0;
        for(int a=0;a<nums.length;a++){
            if(nums[a]!=0){
                nums[b]=nums[a];
                b++;
            }
        }
        for(int i=b;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
