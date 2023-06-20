//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	int ans=0;
	boolean fg=false;
	
	for(int i =0;i<str.length();i++){
	    ans=ans*10;
	    int v=str.charAt(i)-'0';
	    if(i==0&&v<0) {fg=true;
	    continue;}
	    if(v<0||v>9) return -1;
	   ans+=v;
	   
	}
	   
	   
	   
	   if(fg==true) ans*=-1;
	
	
    return ans;
    }
}
