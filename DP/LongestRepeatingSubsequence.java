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
public class LongestRepeatingSubsequence {

    /**
     * @param args the command line arguments
     */
    public int anytwo(String a) {
        /*
        This problem is just the modification of Longest Common Subsequence problem. 
        The idea is to find the LCS(str, str)where str is the input string with the 
        restriction that when both the characters are same, they shouldn’t be on the same 
        index in the two strings.
        */
        int lenA=a.length();
        
        int[][] dp= new int[lenA+1][lenA+1];

        for(int i=0; i<lenA+1; i++){
            for(int j=0; j<lenA+1; j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(a.charAt(i-1)==a.charAt(j-1) && i!=j)
                        dp[i][j]= 1+dp[i-1][j-1];
                    else   
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[lenA][lenA]>=2?1:0;
        
    }
}
/*
Links-
    https://www.interviewbit.com/problems/repeating-subsequence/
Notes-
    https://www.geeksforgeeks.org/longest-repeating-subsequence/
    
    O(n) solution 
    https://www.geeksforgeeks.org/repeated-subsequence-length-2/
*/
