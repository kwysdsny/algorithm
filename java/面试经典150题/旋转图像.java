package 面试经典150题;

public class 旋转图像 {
    /**
     * 不能使用辅助数组
     * 00-02 01-12 02-22 第一个行加第二个列等于n-1 列等于行
     * 10-01 11-11 12-21
     * 两步解决，先矩阵转置，再左右对称的两列互换，OK，解决！
     */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int temp = 0;

            // 矩阵转置
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            // 左右对称的两列互换
            for(int j = 0; j < n / 2; j++){
                for(int i = 0; i < n; i++){
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = temp;
                }
            }

    }
}
