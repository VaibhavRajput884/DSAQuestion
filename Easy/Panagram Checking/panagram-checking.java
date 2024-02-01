//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    public static boolean checkPangram  (String s) {
        s=s.toLowerCase();
        HashMap<Character, Integer> hash = new HashMap<>();
        
        for(int i = 97; i <= 122; i++)
        {hash.put((char)i,0);
          }
          
     for(int i=0;i<s.length();i++)
       {char v=s.charAt(i);
          if(!Character.isWhitespace(v))
          hash.put(v,hash.getOrDefault(v,0)+1); 
        }
        
      for(Map.Entry<Character, Integer> h:hash.entrySet())  
      {
        if(h.getValue()==0)
          {  //System.out.println(h.getKey());
            return false;  
          }
      }
     return true;   
    }
}



//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends