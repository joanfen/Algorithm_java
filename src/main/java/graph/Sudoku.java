package graph;

public class Sudoku {
    private int n = 3;
    private int N = n * n;
    private int [][] rows = new int[N][N + 1];
    private int [][] columns = new int[N][N + 1];
    private int [][] boxes = new int[N][N + 1];
    private char[][] board;
    private boolean sudokuSolved = false;

    /**
     * 当前 row 行 col 列这个格子能不能放置 num 这个数字
     * @param num
     * @param row
     * @param col
     * @return
     */
    public boolean couldPlace(int num, int row, int col) {
        int idx = getBoxIndex(row, col);
        return rows[row][num] + columns[col][num] + boxes[idx][num] == 0;
    }

    /**
     * 将数字放置在棋盘的 row 行，column 列
     * @param num
     * @param row
     * @param column
     */
    public void placeNumber(int num, int row, int column) {
        int idx = getBoxIndex(row, column);
        rows[row][num]++;
        columns[column][num]++;
        boxes[idx][num]++;
        board[row][column] = (char)(num + '0');
    }

    private int getBoxIndex(int row, int column) {
        return (row / n) * n + column / n;
    }

    private void prepareToNext(int row, int column) {
        if ((row == N - 1) && (column == N - 1)) {
            sudokuSolved = true;
        } else {
            if (column == N - 1) backtrack(row + 1, 0);
            else backtrack(row, column + 1);
        }
    }

    private void removeNumber(int num, int row, int column) {
        int idx = getBoxIndex(row, column);
        rows[row][num]--;
        columns[column][num]--;
        boxes[idx][num]--;
        board[row][column] = '.';
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int num = 1; num < 10; num++) {
                if (couldPlace(num, row, col)) {
                    placeNumber(num, row, col);
                    prepareToNext(row, col);
                    if (!sudokuSolved) removeNumber(num, row, col);
                }
            }
        } else {
            prepareToNext(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public static void main(String[] args) {
        char[][] board =  {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new Sudoku().solveSudoku(board);
        System.out.println(board);
    }
}
