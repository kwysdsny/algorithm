package leetcode75;

public class 压缩字符串 {
    public static void main(String[] args) {

    }

    public static int compress(char[] chars) {

        // 获取字符数组的长度
        int n = chars.length;
        // 初始化写入索引和左边界
        int write = 0, left = 0;

        // 遍历字符数组
        for (int read = 0; read < n; read++) {
            // 检查是否到达数组末尾或当前字符与下一个字符不同
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                // 将当前字符写入输出位置
                chars[write++] = chars[read];
                // 计算当前字符的出现次数
                int num = read - left + 1;

                // 如果出现次数大于1，需要写入数字表示
                if (num > 1) {
                    // 记录写入数字的起始位置
                    int anchor = write;
                    // 将出现次数的每一位数字写入字符数组
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0'); // 转换为字符并写入
                        num /= 10; // 去掉最后一位数字
                    }
                    // 反转刚写入的数字，使其顺序正确
                    reverse(chars, anchor, write - 1);
                }
                // 更新左边界，准备处理下一个字符
                left = read + 1;
            }
        }
        // 返回压缩后的新长度
        return write;
    }

    // 反转字符数组中指定范围的字符
    public static void reverse(char[] chars, int left, int right) {
        // 使用双指针法进行反转
        while (left < right) {
            char temp = chars[left]; // 暂存左指针字符
            chars[left] = chars[right]; // 右指针字符赋值给左指针
            chars[right] = temp; // 暂存的左指针字符赋值给右指针
            left++; // 移动左指针向右
            right--; // 移动右指针向左
        }
    }
}


