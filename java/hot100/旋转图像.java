package hot100;

/**
 * 原地旋转，先转置，再左右交换
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        //todo 矩阵转置
        int n = matrix.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n/2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
