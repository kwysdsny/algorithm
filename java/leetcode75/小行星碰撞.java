package leetcode75;

import java.util.*;

public class 小行星碰撞 {
    public static void main(String[] args) {
        int[] a={8,4,-5,-9,10};
        asteroidCollision(a);
    }
    public static int[] asteroidCollision(int[] asteroids) {
        // 使用双端队列作为栈来存储行星的状态
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // 遍历所有的行星
        for (int aster : asteroids) {
            // 变量alive用于表示当前行星是否存活
            boolean alive = true;

            // 当当前行星是负数（向左移动），栈不为空且栈顶行星是正数（向右移动）
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                // 判断栈顶行星是否小于当前行星绝对值（即碰撞）
                alive = stack.peek() < -aster; // 当前行星是否存活

                // 如果栈顶行星小于等于当前行星绝对值，栈顶行星爆炸
                if (stack.peek() <= -aster) {
                    stack.pop(); // 弹出栈顶行星
                }
            }

            // 如果当前行星仍然存活，则将其压入栈中
            if (alive) {
                stack.push(aster);
            }
        }

        // 创建结果数组，大小为栈的当前大小
        int size = stack.size();
        int[] ans = new int[size];

        // 将栈中的元素按顺序填充到结果数组中
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans; // 返回结果数组
    }

}
