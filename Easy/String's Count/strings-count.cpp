//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
long long int countStr(long long int n);

int main(){
    int t;
    cin >> t;
    while(t--){
        long long int n;
        cin >> n;
        cout << countStr(n) << endl;
    }
return 0;
}
// } Driver Code Ends


#define ll long long
long long int countStr(long long int n){
    //complete the function here
    ll allAs = 1;
    ll allA_1b = n;
    ll allA_1c = n;
    ll allA_1b_1c = n * (n - 1);
    ll allA_2c = (n * (n - 1)) / 2;
    ll allA_1b_2c = (n * (n - 1) * (n - 2)) / 2;
    
    return allAs + allA_1b + allA_1c + allA_1b_1c + allA_2c + allA_1b_2c;
}

