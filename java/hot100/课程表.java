package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度数组
        int[] inDegree = new int[numCourses];
        //邻接表, 记录每个课程的后续课程列表
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        //构建邻接表和入度数组
        for(int[] pre:prerequisites){
            int preCourse = pre[1];
            int curCourse = pre[0];
            list.get(preCourse).add(curCourse);
            inDegree[curCourse]++;
        }


        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        //将所有入度为0的课程加入队列
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int nextCourse:list.get(course)){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse]==0){
                    queue.offer(nextCourse);
                }
            }
        }
        return count==numCourses;
    }
}
