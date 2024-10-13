package leetcode75;

public class 反转字符串中的元音字母 {
    public static void main(String[] args) {

    }
    public String reverseVowels(String s) {
        int n = s.length(); // 获取字符串长度
        char[] arr = s.toCharArray(); // 将字符串转换为字符数组
        int i = 0, j = n - 1; // 初始化两个指针，i从前向后，j从后向前

        while (i < j) { // 当i小于j时继续循环
            // 找到第一个元音字母
            while (i < n && !isVowel(arr[i])) {
                ++i; // 如果不是元音，i向右移动
            }
            // 找到第一个元音字母
            while (j > 0 && !isVowel(arr[j])) {
                --j; // 如果不是元音，j向左移动
            }
            // 如果i和j指向的元音字母有效
            if (i < j) {
                swap(arr, i, j); // 交换元音字母
                ++i; // 移动指针i
                --j; // 移动指针j
            }
        }
        return new String(arr); // 返回交换后的字符数组转换为字符串
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0; // 判断字符是否为元音字母
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i]; // 暂存arr[i]的值
        arr[i] = arr[j]; // 将arr[j]的值赋给arr[i]
        arr[j] = temp; // 将暂存的值赋给arr[j]
    }

}
