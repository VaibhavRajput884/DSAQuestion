//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int i, int j, char grid[][], int vis[][]) {
        int n = grid.length;
        int m = grid[0].length;

        vis[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            int row = q.peek().r;
            int col = q.peek().c;
            q.remove();

            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    int newrow = row + r;
                    int newcol = col + c;

                    if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && grid[newrow][newcol] == '1' && vis[newrow][newcol] == 0) {
                        q.add(new Pair(newrow, newcol));
                        vis[newrow][newcol] = 1;
                    }
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    ans++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }
}