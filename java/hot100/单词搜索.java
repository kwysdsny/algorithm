package hot100;

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(dfs(board, i, j, word, 0))
                    return true;
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int i1) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if(board[i][j] != word.charAt(i1))
            return false;
        if(i1 == word.length() - 1)
            return true;

        char temp = board[i][j];
        board[i][j] = '0';
        boolean found=dfs(board, i + 1, j, word, i1 + 1)||dfs(board, i - 1, j, word, i1 + 1)||dfs(board, i, j + 1, word, i1 + 1)||dfs(board, i, j - 1, word, i1 + 1);
        board[i][j] = temp;
        return found;
    }
}
