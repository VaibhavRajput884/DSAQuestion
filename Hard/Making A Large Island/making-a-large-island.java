//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    public int largestIsland(int N, int[][] grid) {
        UnionFind uf = new UnionFind(N * N);
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Step 1: Perform DFS and label connected components
        int label = 2; // Labels start from 2 because 0 and 1 are already used
        int[] componentSizes = new int[N * N + 2]; // +2 to account for 0 and 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, label);
                    componentSizes[label] = size;
                    label++;
                }
            }
        }

        // Step 2: Try changing each 0 to 1 and calculate the new island size
        int maxIslandSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborLabels = new HashSet<>();
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N && grid[ni][nj] != 0) {
                            neighborLabels.add(grid[ni][nj]);
                        }
                    }

                    int newIslandSize = 1; // Include the current 0 in the island
                    for (int neighborLabel : neighborLabels) {
                        newIslandSize += componentSizes[uf.find(neighborLabel)];
                    }

                    maxIslandSize = Math.max(maxIslandSize, newIslandSize);
                }
            }
        }

        // If there is no 0 in the grid, return the size of the largest island
        return maxIslandSize == 0 ? N * N : maxIslandSize;
    }

    private int dfs(int[][] grid, int i, int j, int label) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = label;
        int size = 1;

        size += dfs(grid, i + 1, j, label);
        size += dfs(grid, i - 1, j, label);
        size += dfs(grid, i, j + 1, label);
        size += dfs(grid, i, j - 1, label);

        return size;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}

