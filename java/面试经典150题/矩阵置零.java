package 面试经典150题;

import java.util.HashSet;

public class 矩阵置零 {
    /**
     * 只需用seti,setj存储将哪行那列置0就行
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> seti = new HashSet();
        HashSet<Integer> setj = new HashSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    seti.add(i);
                    setj.add(j);
                }
            }
        }
        for (int i : seti) {
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = 0;
        }
        for (int j : setj) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}

