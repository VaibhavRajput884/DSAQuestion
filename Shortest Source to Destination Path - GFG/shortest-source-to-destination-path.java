//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int r;
    int c;
    int step;
    Pair(int r, int c, int step){
        this.r = r;
        this.c = c;
        this.step = step;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
          
        if( A[0][0] == 0) return -1;
        if(X == 0 && Y == 0 && A[X][Y] == 1) return 0;
        int [][] vis = new int[N][M];
        int step=-1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 0));
        vis[0][0] = 1;
        int [] delrow = {-1, 0, 1, 0};
        int [] delcol = {0, 1, 0, -1};
        int n = A.length, m = A[0].length;
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            if(pair.r == X && pair.c == Y){
                step = pair.step;
                return step;
            }
            for(int i=0; i<4; i++){
                int nrow = delrow[i] +  pair.r;
                int ncol = delcol[i] +  pair.c;
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m
                    && A[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                        queue.add(new Pair(nrow, ncol, pair.step + 1));
                        vis[nrow][ncol] = 1;
                }
            }
        }
       
        return step;
    }
};