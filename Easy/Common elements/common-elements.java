//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[], int n1, int n2, int n3) 
    {
        // code here 
        ArrayList<Integer> list = common(arr1,arr2);
        int[] temp= new int[list.size()];
        for(int i=0;i< list.size();i++){
            temp[i]= list.get(i);
        }
        ArrayList<Integer> list1 = common(temp,arr3);
        return list1;
    }
    
    private static ArrayList<Integer> common(int[] arr1, int[] arr2) {
        int i=0;
        int j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i< arr1.length && j< arr2.length){
//            System.out.println(i);
            if(arr1[i] == arr2[j]){
                if(i<arr1.length-1 && arr1[i]==arr1[i+1]){
                    i= i+1;
                }
                else{
                list.add(arr1[i]);
                i = i+1;
                j = j+1;
                }
            }
            else if(arr1[i] < arr2[j]){
                i = i+1;
            }
            else{
                j = j+1;
            }
        }
        return list;
    }
}