package leetcode75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 省份数量 {
    public static void main(String[] args) {
        int[][] arr={{1,1,0}, {1,1,0},{0,0,1}};
        int n= findCircleNum(arr);
        System.out.println(n);
    }
    public static int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(visited[i] == 1) continue;
            if(visited[i] == 0){
                visited[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    for (int j = 0; j < isConnected[cur].length; j++) {
                        if (isConnected[cur][j] == 1&&i!=j&&visited[j]==0) {
                            visited[j] = 1;
                            queue.add(j);
                        }
                    }
                }

            }

        count++;
        }
        return count;
    }

}
