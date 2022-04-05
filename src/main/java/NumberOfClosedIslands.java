import java.util.HashSet;
import java.util.Set;

public class NumberOfClosedIslands {

//    public

    public int closedIsland(int[][] grid) {
        int[] rootArr = new int[grid.length * grid[0].length + 1];
        for (int i = 1; i < rootArr.length; i++) {
            rootArr[i] = i;
        }

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int idx = (grid[0].length * i) + j + 1;
                int root = find(rootArr, idx);
                if (grid[i][j] == 0 && idx == root) {
                    set.add(root);
                    int res = dfs(grid, rootArr, root, i, j);
                    if (res > 0) {
                        set.remove(root);
                    }
                }
            }
        }

        return set.size();
    }

    public int dfs(int[][] grid, int[] rootArr, int root, int i, int j) {
        int res = 0;

        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0) {
            int idx = (grid[0].length * i) + j + 1;
            union(rootArr, idx, root);
            grid[i][j] = 1;
            if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                res++;
            }

            res += dfs(grid, rootArr, root, i + 1, j);
            res += dfs(grid, rootArr, root, i - 1, j);
            res += dfs(grid, rootArr, root, i, j + 1);
            res += dfs(grid, rootArr, root, i, j - 1);

        }
        return res;
    }

    public int find(int[] rootArr, int val) {
        if (rootArr[val] == val) return val;
        else return find(rootArr, rootArr[val]);
    }

    public void union(int[] rootArr, int cur, int prev) {
        int curVal = find(rootArr, cur);
        int prevVal = find(rootArr, prev);
        rootArr[curVal] = prevVal;
    }

    public static void main(String args[]) {
        NumberOfClosedIslands a = new NumberOfClosedIslands();
        int[][] grid =

                {
                          {1, 1, 1, 1, 1, 1, 1, 0}
                        , {1, 0, 0, 0, 0, 1, 1, 0}
                        , {1, 0, 1, 0, 1, 1, 1, 0}
                        , {1, 0, 0, 0, 0, 1, 0, 1}
                        , {1, 1, 1, 1, 1, 1, 1, 0}
                };
        System.out.println(a.closedIsland(grid));
    }
}
