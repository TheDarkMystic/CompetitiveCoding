/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example,
Given:

s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
package interviewprep.DP;

/**
 *
 * @author jakadam
 */
public class InterleavingStrings {
    public int isInterleave(String a, String b, String c) {
        char str1[]=a.toCharArray();
        char str2[]=b.toCharArray();
        char str3[]=c.toCharArray();
        
        int len1=str1.length, len2=str2.length, len3=str3.length;
        if(len1+len2!=len3) return 0;
        
        boolean [][] dp= new boolean[len1+1][len2+1];
        
        for(int i=0; i<=len1; i++)
            for(int j=0; j<=len2; j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                } else if(i==0){
                    dp[i][j]=(dp[i][j-1] && str2[j-1]==str3[i+j-1]);
                } else if(j==0){
                    dp[i][j]=(dp[i-1][j] && str1[i-1]==str3[i+j-1]);
                } else{
                    dp[i][j]=((dp[i-1][j] && str1[i-1]==str3[i+j-1]) ||
                                (dp[i][j-1] && str2[j-1]==str3[i+j-1]) );
                }
            }
        return dp[len1][len2]==true?1:0;
    }
}


/*

Links-


Notes-

https://leetcode.com/problems/interleaving-string/discuss/31879/My-DP-solution-in-C%2B%2B

https://www.youtube.com/watch?v=ih2OZ9-M3OM

https://leetcode.com/articles/interleaving-strings/#approach-2-recursion-with-memoization-accepted


Here is some explanation:

DP table represents if s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at 
jth position. 0th position means empty string.

So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving. If only s1 
is empty, then if previous s2 position is interleaving and current s2 position char is equal to s3 
current position char, it is considered interleaving. similar idea applies to when s2 is empty. when 
both s1 and s2 is not empty, then if we arrive i, j from i-1, j, then if i-1,j is already interleaving 
and i and current s3 position equal, it s interleaving. If we arrive i,j from i, j-1, then if i, j-1 is 
already interleaving and j and current s3 position equal. it is interleaving.

*/