//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
       List<String> res = new ArrayList<String>();
       permutation_func("",S,res);
       Collections.sort(res);
      HashSet<String> set = new HashSet<>(res);
      List<String> list = new ArrayList<String>(set);
        Collections.sort(list);
       return list;
    }
   public void permutation_func(String op, String in, List<String> res){
        if(in.isEmpty()){
            res.add(op);
            return;
        }
         char c = in.charAt(0);
    for(int i = 0 ; i<=op.length(); i++){
        String s = op.substring(0,i);
        String e = op.substring(i,op.length());
        permutation_func(s+c+e,in.substring(1),res);
    }
    }
}