package hot100;

public class 搜索二维矩阵II {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7,9}, {2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        searchMatrix(matrix, 13);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0;
        int direction = 1;//1向下，0向左
        for (; j < n; j++) {
            if (matrix[0][j] == target) return true;
            else if (matrix[0][j] > target) {
                break;
            }
        }
        j--;
        while (i < m && j < n&&i>=0&&j>=0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target&&direction==1) {
                direction = 0;
                j--;
            }
            else if (matrix[i][j] < target&&direction==1) {
                i++;
            }
            else if (matrix[i][j] > target&&direction==0) {
                j--;
            }
            else if (matrix[i][j] < target&&direction==0) {
                direction = 1;
                i++;
            }
        }
        return false;
    }
}
