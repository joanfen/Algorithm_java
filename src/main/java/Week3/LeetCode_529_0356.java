package Week3;

public class LeetCode_529_0356 {

    int[] dx = {-1, -1, -1, 0,  0,  1, 1, 1};
    int[] dy = {-1,  0,  1, 1, -1, -1, 0, 1};
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    public void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'E') {
            board[i][j] = 'B';
            int count = judge(board, i, j);
            if (count == 0) {
                for (int k = 0; k < dx.length; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
                        dfs(board, x, y);
                    }
                }
            } else {
                board[i][j] = (char) (count + '0') ;

            }
        } else if(board[i][j] == 'M') {
            board[i][j] = 'X';
        }
    }

    private int judge(char[][] board, int i, int j) {

        int count = 0;
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
                if (board[x][y] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }

}
