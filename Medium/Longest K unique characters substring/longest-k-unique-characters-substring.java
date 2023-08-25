//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   public int longestkSubstr(String s, int k) {
        // code here
        int high=0,low=0,len=s.length();
        Map<Character,Integer> freq = new HashMap<>();
        int uniqueCharacters=0,max=-1;
        while(high<len){
            char currCh = s.charAt(high);
            if(freq.containsKey(currCh)){
                freq.put(currCh,freq.get(currCh)+1);
            }else{
                uniqueCharacters++; // add new unique char
                freq.put(currCh,1);
            }
            if(uniqueCharacters==k){
                // calculate ans
                max=Math.max(max,high-low+1);
            }
            while(uniqueCharacters>k){
                char lowCh=s.charAt(low);
                int lowChFreq = freq.get(lowCh);
                if(lowChFreq==1){
                    uniqueCharacters--;
                    freq.remove(lowCh);
                }else{
                    freq.put(lowCh,lowChFreq-1);
                }
                low++;
            }
            high++;
        }
        return max; 
    }
}