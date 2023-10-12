//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        
        
        //brute force approch
        
        /*int count = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(k-arr[i] == arr[j]) {
                    count++;
                }
            }
        }
        
        return count;*/
        
        
        //naive approach
        
        //taking count in which we store how many pairs of the target some are here
        int count = 0; 
        
        //to store the frequency for each element that how many time it generates the target some with another element of given array
        HashMap <Integer , Integer> map = new HashMap<>();
        
        //we run a loop from 0th element to nth element to put the frequency of every element in map that how many time it get paired with another element of array to generate the target output
        for(int i = 0; i < n; i++) {
            //target element for the present element is stored in target which will goes to key
            int target = k - arr[i];
            //incement the count by frqency of given element if it is already present in hashmap or just dont do anything
            count += map.getOrDefault(target , 0);
            //put present element in hashmap if it is not present in map and give it the frquency of 1 or else just increse the frequency of already present element by 1
            map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
        }
        
        //return the count that will have all posible pairs count
        return count;
    }
}