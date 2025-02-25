package leetcode75;

import java.util.*;

public class 钥匙和房间 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (!visited.contains(cur))
            {
                visited.add(cur);
                for (Integer n : rooms.get(cur)){
                    queue.add(n);
                }
            }

        }
        return visited.size() == rooms.size();
    }
}
