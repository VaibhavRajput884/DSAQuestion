//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
     static void merge(int arr[], int l, int m, int r)
    {
         // Your code here
          //i...mid -- first sorted array
    //mid+1....r -- second sorted array 
    int []b = new int[r-l+1]; // craeting a new array with size of r-l+1
    int i = l ; // i will be at starting of first subaary
    int j = m+1 ; // j will be at starting of second array i.e mid+1
    int k = 0 ; // k will be at starting of new array
    
    while(i<=m && j<=r)  // till the valid index 
    {
        if(arr[i]<=arr[j])
        {
            b[k]=arr[i];
            i++;
            k++;
        }
        else
        {
            b[k]=arr[j];
            j++;
            k++;
        }
    }
    
    while(i<=m)
    {
            b[k]=arr[i];
        i++;
        k++;         
    }
    
    while(j<=r)
    {
       b[k]=arr[j];
       j++;
       k++;  
    }
    
    // array is ready here 
    // copy back
    k = 0 ;
    for(int p=l; p<=r; p++)
    {
       arr[p]=b[k];
       k++;
    }
}
 
    
   static void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l<r)
    {
        int mid = (l+r)/2 ;
        mergeSort(arr,l,mid);  // sort the left part
        mergeSort(arr,mid+1,r);  // sort the right part 
        merge(arr,l,mid,r); // merge sort 
    }
    }
}