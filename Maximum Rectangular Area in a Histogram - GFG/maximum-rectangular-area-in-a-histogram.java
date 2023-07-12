//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        
         long maxArea=0;
        int nsr[]=new int[hist.length];
        int nsl[]=new int[hist.length];

        
        Stack<Integer> s=new Stack<>();
        for(int i=hist.length-1;i>=0;i--){
            while(!s.isEmpty() && hist[s.peek()]>=hist[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=hist.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        
         s=new Stack<>();
        for(int i=0;i<hist.length;i++){
            while(!s.isEmpty() && hist[s.peek()]>=hist[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        
        for(int i=0;i<hist.length;i++){
            long height=hist[i];
            long width=nsr[i]-nsl[i]-1;
            long currArea=height*width;
            maxArea=Math.max(currArea,maxArea);
        }
        return maxArea;
    }
        
}



