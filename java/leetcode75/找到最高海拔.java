package leetcode75;

public class 找到最高海拔 {
    public static void main(String[] args) {

    }
    public static int largestAltitude(int[] gain) {
        int result = 0;
        int currentheight = 0;
        for (int i = 0; i < gain.length; i++) {
            currentheight += gain[i];
            result=Math.max(result,currentheight);
        }
        return result;
    }
}



