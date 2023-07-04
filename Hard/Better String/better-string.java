//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        int s1=countSub( str1);
        int s2=countSub( str2);
        if(s1>s2){
        return str1;
        }
        else if(s1==s2){
            return str1;
        }
        return str2;
    
}
    public static int countSub(String s)
  {
    HashMap<Character,
             Integer> map = new HashMap<Character,
                                        Integer>();
 
    // Iterate from 0 to s.length()
    for(int i = 0; i < s.length(); i++)
    {
      map.put(s.charAt(i), -1);
    }
     
    int allCount = 0;
    int levelCount = 0;
     
    // Iterate from 0 to s.length()
    for(int i=0;i<s.length();i++)
    {
      char c = s.charAt(i);
       
      // Check if i equal to 0
      if(i==0)
      {
        allCount = 1;
        map.put(c,1);
        levelCount = 1;
        continue;
      }
       
      // Replace levelCount with
      // allCount + 1
      levelCount = allCount + 1;
       
      // If map is less than 0
      if(map.get(c)<0)
      {
        allCount = allCount + levelCount;
      }
      else
      {
        allCount = allCount + levelCount - map.get(c);
      }
      map.put(c,levelCount);
    }
     
    // Return answer
    return allCount;
 
  }
}