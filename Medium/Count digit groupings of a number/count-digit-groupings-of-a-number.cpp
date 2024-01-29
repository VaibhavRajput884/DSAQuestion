//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
	public:
	
	int solve(int currpos,int prevsum,int size,string s,vector<vector<int>>&dp){
	    
	    if(currpos==size) return 1;
	    if(dp[currpos][prevsum]!=-1) return dp[currpos][prevsum];
	    int sum=0,count=0;
	    
	    for(int i=currpos;i<size;i++){
	        sum+=s[i]-'0';
	        
	        if(sum>=prevsum){
	            
	            count+=solve(i+1,sum,size,s,dp);
	        }
	    }
	    
	    return dp[currpos][prevsum]=count;
	}
	
	int TotalCount(string str){
	    // Code here
	    int sum=0;
	    for(auto i : str) sum+=i-'0';
	    vector<vector<int>>dp(str.size()+1,vector<int>(sum+1,-1));
	    return solve(0,0,str.size(),str,dp);
	}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string str;
		cin >> str;
		Solution ob;
		int ans = ob.TotalCount(str);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends