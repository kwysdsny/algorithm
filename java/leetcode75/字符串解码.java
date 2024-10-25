package leetcode75;

import java.util.LinkedList;
import java.util.Collections;

class 字符串解码{
    int ptr; // 指针，用于遍历输入字符串

    public static void main(String[] args) {
        
    }
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>(); // 创建一个栈，用于存储解码的部分
        ptr = 0; // 初始化指针为0

        // 遍历输入字符串
        while (ptr < s.length()) {
            char cur = s.charAt(ptr); // 获取当前字符
            if (Character.isDigit(cur)) {
                // 如果当前字符是数字，获取整个数字并将其压入栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 如果当前字符是字母或者是左括号，将其压入栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                // 当前字符是右括号，开始解码
                ++ptr; // 移动指针到下一个字符
                LinkedList<String> sub = new LinkedList<String>(); // 用于存储子字符串

                // 将栈中元素取出，直到遇到左括号为止
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub); // 反转子字符串，因为它们是倒序存储的

                // 左括号出栈
                stk.removeLast();

                // 此时栈顶为当前子字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast()); // 从栈中获取重复次数
                StringBuffer t = new StringBuffer(); // 用于构造结果字符串
                String o = getString(sub); // 将子字符串合并为一个字符串

                // 根据重复次数构造最终的字符串
                while (repTime-- > 0) {
                    t.append(o); // 将合并后的字符串重复添加
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        // 最终将栈中的所有元素合并为一个字符串并返回
        return getString(stk);
    }

    // 获取当前指针位置的数字，并移动指针
    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++)); // 追加数字到结果并移动指针
        }
        return ret.toString(); // 返回获取的数字
    }

    // 合并字符串列表为一个字符串
    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s); // 将每个字符串追加到结果中
        }
        return ret.toString(); // 返回合并后的字符串
    }
}

