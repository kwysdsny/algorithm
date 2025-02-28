package leetcode75;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 屎山代码，未通过，思路正确
 */
public class 迷宫中离入口最近的出口 {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue queue = new LinkedList<>();
        int[] a=new int[]{entrance[0], entrance[1],0};
        queue.offer(a);
        while(!queue.isEmpty()) {
            int[] point = (int[]) queue.poll();
            int x = point[0];
            int y = point[1];
            int count=point[2];
            if((x==0||y==0||x==maze.length-1||y==maze[0].length-1)&&(entrance[0]!=x||entrance[1]!=y))
                return count;
            if(y-1>=0&&y-1< maze[0].length&&maze[x][y-1]=='.') queue.offer(new int[]{x, y - 1,count+1});
            if(y+1>=0&&y+1< maze[0].length&&maze[x][y+1]=='.') queue.offer(new int[]{x, y + 1,count+1});
            if(x-1>=0&&x-1< maze.length&&maze[x-1][y]=='.') queue.offer(new int[]{x-1, y ,count+1});
            if(x+1>=0&&x+1< maze.length&&maze[x+1][y]=='.') queue.offer(new int[]{x+1, y ,count+1});
            maze[x][y] = '+';

        }
        return -1;
    }
}
