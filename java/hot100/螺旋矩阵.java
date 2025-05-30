package hot100;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        List<Integer> list = new ArrayList<>();
        //定义方向，向上为1，向又为2，向下为3，向左为4
        int direction = 2;
//        int currentindex = -1;
        int arri = 0;
        int arrj = 0;
        while (list.size() < m * n) {
            if (arri < m && arrj < n && arri >= 0 && arrj >= 0 && visited[arri][arrj] == 0) {
                list.add(matrix[arri][arrj]);
                visited[arri][arrj] = 1;
                if (direction == 1) {
                    arri--;
                } else if (direction == 2) {
                    arrj++;
                } else if (direction == 3) {
                    arri++;
                } else if (direction == 4) {
                    arrj--;
                }
            } else {
                if (direction == 1) {
                    direction = 2;
                    arri++;
                    arrj++;
                } else if (direction == 2) {
                    direction = 3;
                    arrj--;
                    arri++;
                } else if (direction == 3) {
                    direction = 4;
                    arri--;
                    arrj--;
                } else if (direction == 4) {
                    direction = 1;
                    arrj++;
                    arri--;
                }
            }
        }
        return list;
    }
}
