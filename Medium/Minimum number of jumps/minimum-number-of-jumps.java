//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        //  int n = arr.length;

        // int farthest=0,jumps=0,current=0;

        // for(int i=0;i<n-1;i++){

        //     farthest=Math.max(farthest,arr[i]+i);

        //     if(i==current){

        //         current=farthest;

        //         jumps++;

        //     }

        // }

        // if(current<n-1) return -1;

        // return jumps; 

        int n=arr.length;
        int step=0;
        int jump=0;
        int count=0;
        for(int i =0;i<n-1;i++){
            step=Math.max(step,arr[i]+i);
            if(i==count){
                count=step;
                jump++;
            }
        }
         if(count<n-1) return -1;
        return  jump;
    }
}