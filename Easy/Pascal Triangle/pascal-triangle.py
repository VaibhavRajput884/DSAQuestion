#User function Template for python3

#User function Template for python3
class Solution:
    def __init__(self):
        self.mod = 10 ** 9 + 7
    
    def modInverse(self, a):
        return pow(a, self.mod - 2, self.mod)
    
    def nthRowOfPascalTriangle(self, n):
        ans = [1] * n
        for i in range(1, n):
            ans[i] = (ans[i - 1] * (n - i) * self.modInverse(i)) % self.mod

        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 

	tc=int(input())
	while tc > 0:
	    n=int(input())
	    ob = Solution()
	    ans=ob.nthRowOfPascalTriangle(n)
	    for x in ans:
	        print(x, end=" ")
	    print()
	    tc=tc-1
# } Driver Code Ends