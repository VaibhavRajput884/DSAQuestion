//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        csort(arr, n);
        for(int i = 0; i < n; i++)
            if(arr[i] != i + 1)
                return i + 1;
        return n + 1;
    }
    
    static void csort(int arr[], int n) {
        int i = 0;
        while(i < n) {
            if(arr[i] > 0 && arr[i] < n && arr[i] != arr[arr[i] - 1])
                arr[i] ^= arr[arr[i] - 1] ^ (arr[arr[i] - 1] = arr[i]);
            else
                i++;
        }
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends