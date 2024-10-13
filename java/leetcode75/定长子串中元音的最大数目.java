package leetcode75;

import java.util.HashMap;

/**
 * 滑动窗口
 */
public class 定长子串中元音的最大数目 {
    public static void main(String[] args) {

    }
    public static int maxVowels(String s, int k) {
        String str= "aeiou";
        int i=0,j=k-1;
        int res=0,cur=0;
        for (;i<=j;i++){
            if(str.indexOf(s.charAt(i))!=-1){
                cur++;
            }
        }
        res=cur;
        for(i=1,j=k;j<s.length();i++,j++){
            if(str.indexOf(s.charAt(i-1))!=-1){
                cur--;
            }
            if(str.indexOf(s.charAt(j))!=-1){
                cur++;
            }
            res=Math.max(res,cur);
        }
        return res;
    }
}
