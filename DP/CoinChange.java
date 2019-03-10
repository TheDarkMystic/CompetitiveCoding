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
import java.util.*;
public class CoinChange {
    
    //BOTTOM UP(Iterative DP)
     public int coinChange(int[] coins, int amount) {
        // We use this to fill the dp table with default values
        int max = amount + 1;

        // This table will store the answer to our sub problems
        int[] dp = new int[amount + 1];

        // Initialize the dp table
        Arrays.fill(dp, max);  

        /*
          The answer to making change with minimum coins for 0
          will always be 0 coins no matter what the coins we are
          given are
        */
        dp[0] = 0;

        // Solve every subproblem from 1 to amount
        for (int amt = 1; amt <= amount; amt++) {
          // For each coin we are given
          for (int coin: coins) {
            // If it is less than or equal to the sub problem amount
            if (coin <= amt) {
              // Try it. See if it gives us a more optimal solution
              dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
            }
          }
        }

        /*
          dp[amount] has our answer. If we do not have an answer then dp[amount]
          will be amount + 1 and hence dp[amount] > amount will be true. We then
          return -1.
          Otherwise, dp[amount] holds the answer
        */
        return dp[amount] > amount ? -1 : dp[amount];
    
    }
     
     //TOP DOWN(RecursiveDP)
     
}


/*
ProblemUrls:
I-https://leetcode.com/problems/coin-change/
NOTES:
https://www.youtube.com/watch?v=jgiZlGzXMBw&t=162s&index=10&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI
*/

