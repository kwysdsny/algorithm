package leetcode75;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 双队列对决
 */
public class Dota2参议院 {
    public String predictPartyVictory(String senate) {
        // 获取 senate 字符串的长度
        int n = senate.length();

        // 创建两个队列，分别用于存储“Radiant”和“Dire”党派的成员索引
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();

        // 遍历 senate 字符串，将每个党派成员的索引存入对应的队列
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i); // 如果是 'R'，加入 radiant 队列
            } else {
                dire.offer(i); // 如果是 'D'，加入 dire 队列
            }
        }

        // 当两个队列都不为空时，进行战斗
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            // 取出各队列的队头成员索引
            int radiantIndex = radiant.poll(), direIndex = dire.poll();

            // 比较两个成员的索引，索引较小的获胜
            if (radiantIndex < direIndex) {
                // Radiant 获胜，将其索引加上 n 重新入队，表示下一个回合
                radiant.offer(radiantIndex + n);
            } else {
                // Dire 获胜，将其索引加上 n 重新入队，表示下一个回合
                dire.offer(direIndex + n);
            }
        }

        // 判断哪个队列不为空，返回获胜党派的名称
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

}
