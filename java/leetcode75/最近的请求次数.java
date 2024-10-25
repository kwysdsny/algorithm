package leetcode75;

import java.util.ArrayDeque;
import java.util.Queue;

public class 最近的请求次数 {
    /**
     * 队列。。。。。。
     */
    class RecentCounter {
        // 定义一个队列来存储最近的请求时间
        Queue<Integer> queue;

        // 构造函数，初始化队列
        public RecentCounter() {
            queue = new ArrayDeque<Integer>();
        }

        // ping 方法，接收一个时间 t，并返回在 t 时间内的 ping 调用次数
        public int ping(int t) {
            // 将当前的 ping 时间 t 加入队列
            queue.offer(t);

            // 移除队列中不在 3000 毫秒范围内的时间戳
            while (queue.peek() < t - 3000) {
                queue.poll();  // 移除队首元素
            }

            // 返回队列的大小，即在过去 3000 毫秒内的 ping 调用次数
            return queue.size();
        }
    }


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
