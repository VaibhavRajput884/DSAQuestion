//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
        public static ArrayList<Integer> duplicates(int arr[], int n) {
        Set<Integer> s = new HashSet<>();
        Set<Integer> a = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!s.contains(arr[i])){
                s.add(arr[i]);
            }
            else
                a.add(arr[i]);
        }
        if(a.isEmpty()) a.add(-1);
        for(int i : a){
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}
