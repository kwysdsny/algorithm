package 面试经典150题;

public class 有效的数独 {
    /**
     * 将三个判断条件分别将二维数组存三个hashmap中进行判断
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[9][9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1;
                    rows[i][index]++;
                    cols[j][index]++;
                    //判断第几个数组
                    boxes[i / 3][j / 3][index]++;
                }
            }
        }
        /**
         * 可以直接在上面if中判断
         * if (rows[i][index]>1||columns[j][index]>1||box[i/3][j/3][index]>1){
         *                         return false;
         *                     }
         */
        for (int[] row : rows) {
            for (int i : row) {
                if (i > 1) return false;
            }
        }
        for (int[] col : cols) {
            for (int i : col) {
                if (i > 1) return false;
            }
        }
        for (int[][] row : boxes) {
            for (int[] i : row) {
                for (int j : i) {
                    if (j > 1) return false;
                }
            }
        }
        return true;
    }
}
