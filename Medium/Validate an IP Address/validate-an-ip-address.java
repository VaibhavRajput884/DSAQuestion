//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean in_range(String s)
    {
        if(s.length()==0)
        return false;
        if(s.charAt(0)=='0' && s.length()>1)
        return false;
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)
            sum=sum*10+(s.charAt(i)-'0');
            else
            return false;
        }
        if(sum>=0 && sum<=255)
        return true;
        return false;
    }
    public boolean isValid(String s) {
        if(s.charAt(s.length()-1)=='.')
        return false;
        String a[]=s.split("\\.");
        if(a.length!=4)
        return false;
        for(String i:a)
        {
            if(!in_range(i))
            return false;
        }
        return true;
    }
}