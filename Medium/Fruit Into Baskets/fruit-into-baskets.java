//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        
        HashMap<Integer,Integer> m=new HashMap<>();
        
        int i =0;
        int j=0;
        int ans =0;
        while(j<N){
            int val=m.getOrDefault(fruits[j],0);
            m.put(fruits[j],val+1);
            
            while(m.size()>2){
                if(m.get(fruits[i])==1){
                    m.remove(fruits[i]);
                }else{
                    int val1=m.get(fruits[i]);
                    m.put(fruits[i],val1-1);
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}