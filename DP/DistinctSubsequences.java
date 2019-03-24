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
public class DistinctSubsequences {
/*
    When you see string problem that is about subsequence or matching, dynamic programming 
    method should come to mind naturally. The key is to find the initial and changing condition.
    */
    
    public int numDistinct(String A, String B) {
        //Read the commented algo for recursive solution. That makes writting DP trivial.
        int Alen=A.length();
        int Blen=B.length();
        
        int dp[][]=  new int[Alen+1][Blen+1];
        
        //initialize first row
        for(int i=0; i<Blen+1; i++) dp[0][i]=0;
        //initialize first row
        for(int i=0; i<Alen+1; i++) dp[i][0]=1;
        
        //populating DP table
        for(int i=1; i<Alen+1; i++){
            for(int j=1; j<Blen+1; j++){
                if(A.charAt(i-1)==B.charAt(j-1))
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[Alen][Blen];
    
    }
}
/*
Link- 
https://www.interviewbit.com/problems/distinct-subsequences/
Notes-
http://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/
https://www.programcreek.com/2013/01/leetcode-distinct-subsequences-total-java/


https://leetcode.com/problems/distinct-subsequences/#/solutions

*/

/*

// Returns count of subsequences of S that match T 
// m is length of T and n is length of S
subsequenceCount(S, T, n, m)

   // An empty string is subsequence of all.
   1) If length of T is 0, return 1.

   // Else no string can be a sequence of empty S.
   2) Else if S is empty, return 0.
    
   3) Else if last characters of S and T don't match,
      remove last character of S and recur for remaining
        return subsequenceCount(S, T, n-1, m)

   4) Else (Last characters match), the result is sum
      of two counts.
        
        // Remove last character of S and recur. This makes sure we count the solutions with 
        // remaining part of S and full T. Otherwise recursion will end when we encounter first subseq.
        // without counting remaining subseq
        a) subsequenceCount(S, T, n-1, m) + 

        // Remove last characters of S and T, and recur.
        b) subsequenceCount(S, T, n-1, m-1)        
*/        
    

