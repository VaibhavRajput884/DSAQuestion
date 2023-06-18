class Solution {
    public String longestCommonPrefix(String[] arr) {
        int n=arr.length;
        if(n==0) return "";
        String prefix=arr[0];
        for(int i=0;i<n;i++){
            while(arr[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        
        if(prefix.isEmpty()) return "";
            
        return prefix;
    }
}