//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
   static List<Integer> nextPermutation(int N, int arr[]){
        
      ArrayList<Integer> list = new ArrayList<>();
      int index = -1;
      
      /// finding the breakpoint for which we will swap further if exsits 
      // important going till zero because the first no can also be replaced 
      
    
    for(int i = N-2 ; i >= 0 ; i--){
        if(arr[i] < arr[i+1]){
            index= i ;
            break ;
        }
    }
  
  // if in last permutation then just reverse it and give it to initals 
  
   if(index == -1 ){
       
        for(int i =0 ; i< N ;i++){
            list.add(arr[i]);
        }
         Collections.reverse(list);
        return list;
   }
   
   
   //swapping the index that will be next greatert than the elemnt but samllest from right side 
   for(int i = N-1 ; i>= index ;i--){
       if(arr[i] > arr[index]){
          int temp = arr[index];
          arr[index] = arr[i];
          arr[i] = temp;
          break;
       }
       
   }
   
   
   //adding to the Arraulist
   
   for(int i =0 ; i< N ;i++){
            list.add(arr[i]);
        }
 
 // taking a subpart and reversing it from right side 
    List<Integer> sublist = list.subList(index + 1, N);
        Collections.reverse(sublist);
 
 
 
 //returnig the list 
  return list;
 
 
 
 
 
 
 
 
 
       
}
}