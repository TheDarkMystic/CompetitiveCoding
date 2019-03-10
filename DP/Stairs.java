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

public class Stairs {
    /*
    //Recursive without memoization
    public int climbStairs(int A) {
        if(A==0)
            return 1;
        if(A<0)
            return 0;
        int ways=climbStairs(A-1)+climbStairs(A-2);
        
        return ways;
        
    }
    */
    // iterative solution
    
    public int climbStairs(int A) {
        int dp[] = new int[A+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2; i<dp.length; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        
        return dp[A];
    }
}
/*
Links-https://www.interviewbit.com/problems/stairs/
Notes-
https://www.youtube.com/watch?v=CFQk7OQO_xM
https://www.youtube.com/watch?v=NFJ3m9a1oJQ&t=914s
https://leetcode.com/problems/climbing-stairs/#/solutions
*/