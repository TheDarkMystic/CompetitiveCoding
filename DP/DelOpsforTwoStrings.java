/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.DP;

/**
 *
 * @author jakadam
 */

/*
To make them identical, just find the longest common subsequence. The rest of the characters have to be 
deleted from the both the strings, which does not belong to longest common subsequence.
*/
class DelOpsforTwoStrings {
    public int minDistance(String a, String b) {
        int lenA=a.length();
        int lenB=b.length();
        
        if(lenA==0||lenB==0)
            return Math.max(lenA,lenB);
        
        int[][] dp= new int[lenA+1][lenB+1];

        for(int i=0; i<lenA+1; i++){
            for(int j=0; j<lenB+1; j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(a.charAt(i-1)==b.charAt(j-1))
                        dp[i][j]= 1+dp[i-1][j-1];
                    else   
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        int lcs=dp[lenA][lenB];
        
        return (lenA-lcs)+(lenB-lcs);
    }
}
/*
Links-
    https://leetcode.com/problems/delete-operation-for-two-strings/
Notes-
    https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)
    https://leetcode.com/problems/delete-operation-for-two-strings/solution/
*/