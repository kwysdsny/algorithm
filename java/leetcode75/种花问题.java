package leetcode75;

public class 种花问题 {
    public static void main(String[] args) {

    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0&&(i+1==flowerbed.length||flowerbed[i+1] == 0)&&(i-1==-1||flowerbed[i-1]==0))
            {
                n=n-1;
                flowerbed[i]=1;
            }
        }
        if (n<=0) return true;
        else return false;
    }
}
