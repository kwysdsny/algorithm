package hot100;

public class 盛最多水的容器 {
    public static void main(String[] args) {

    }
    public static int maxArea(int[] height) {
        int i =0,j=height.length-1;
        int area = 0;
        while(i<j){
            area = Math.max(area,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<=height[j]){
                i++;
            }
            else if(height[i]>height[j]){
                j--;
            }
        }
        return area;
    }
}
