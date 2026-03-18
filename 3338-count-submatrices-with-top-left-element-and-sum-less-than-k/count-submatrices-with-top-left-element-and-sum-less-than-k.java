class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                grid[r][c] += (r > 0) ? grid[r - 1][c] : 0;
                grid[r][c] += (c > 0) ? grid[r][c - 1] : 0;
                grid[r][c] -= (c > 0 && r > 0) ? grid[r - 1][c - 1] : 0;
                if (grid[r][c] <= k)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}