//{ Driver Code Starts
/* Driver program to test above function */

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    int buyMaximumProducts(int n, int k, int price[]){
        //Write your code here
       // vector<vector<int>> vect(n , vector<int>(2));
        unordered_map<int,vector<int>> mp ;
        for(int i = 0 ; i < n ; i++)
        {
            mp[price[i]].push_back(i+1);
        }
        int count = 0;
        sort(price , price+n);
        for(int i = 0 ; i < n&&k>0 ; i++)
        {
            int prices = price[i];
            int maxi = mp[prices][mp[prices].size()-1] ;
            mp[prices].pop_back();
            int si = 0 ; 
            int ei = maxi ;
            int cun = 0 ;
            while(si<=ei)
            {
                int mid = (si+ei)/2 ;
                if(mid*prices == k)
                {
                    cun = mid ;
                    break;
                }
                else if(mid*prices >k)
                {
                    ei = mid-1 ;
                    
                }
                else
                {
                    cun = max(cun , mid);
                    si=mid+1 ;;
                }
            }
            count+=cun ;
            k = k-(cun*prices);
        }
        return count ;
    }
};


//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n, k;
	    cin >> n >> k;
	    int price[n];
	    for(int i = 0 ; i < n; i++){
	        cin >> price[i];
	    }
	    Solution ob;
	    int ans = ob.buyMaximumProducts(n, k, price);
	    cout << ans<<endl;
	}
	return 0;
}

// } Driver Code Ends