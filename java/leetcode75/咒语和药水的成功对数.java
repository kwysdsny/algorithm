package leetcode75;

import java.util.Arrays;

public class 咒语和药水的成功对数 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int s,p;
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
                res[i]=potions.length-find(i,spells,potions,success);
        }
        return res;
    }
    public static int find(int i,int[] spells, int[] potions, long success){
        int left=0,right=potions.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if((long)spells[i]*potions[mid]>=success){
                right=mid-1;
            }
            else if((long)spells[i]*potions[mid]<success){
                left=mid+1;
            }

        }
        return left;
    }
}
