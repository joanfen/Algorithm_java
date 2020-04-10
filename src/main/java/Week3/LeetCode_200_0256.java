package Week3;

public class LeetCode_200_0256 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    char[][] g;

    public int numIslands(char[][] grid) {
        g = grid;
        int islands = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '0') continue;
                islands += sink(i, j);
            }
        }
        return islands;
    }

    int sink(int i, int j) {
        if (g[i][j] == '0') return 0;
        g[i][j] = '0';
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < g.length && y > 0 && y < g[i].length) {
                if (g[x][y] == '0') continue;
                sink(x, y);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        LeetCode_200_0256 code = new LeetCode_200_0256();
        char[][] a = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(code.numIslands(a));
    }

}
