/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

Example :

Input : 
	S = [1, 2, 3] 
	N = 4

Return : 4

Explanation : The 4 possible ways are
{1, 1, 1, 1}
{1, 1, 2}
{2, 2}
{1, 3}	
Note that the answer can overflow. So, give us the answer % 1000007
*/

package interviewprep.DP;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class CoinSumInfinite {
    public int coinchange2(ArrayList<Integer> A, int B) {
        int noOfCoins=A.size();
        int amt=B;
        int dp[][] = new int[noOfCoins+1][amt+1];
        
        dp[0][0]=1;
        
        for(int i=1;i<=noOfCoins;i++){
            dp[i][0]=1;
            for(int j=1;j<=amt;j++){
                if(j<A.get(i-1))
                    dp[i][j]=dp[i-1][j]% 1000007;
                else
                    dp[i][j]=(dp[i][j-A.get(i-1)]+dp[i-1][j])% 1000007;
            }
        }
        
        return dp[noOfCoins][amt];
    }
    
    
}
/*
Links-https://www.interviewbit.com/problems/coin-sum-infinite/
Notes-
classic problem AKA integer partition   AKA knapsack 

https://www.youtube.com/watch?v=DJ4a7cmjZY0&t=480s


code from here
https://discuss.leetcode.com/topic/79071/knapsack-problem-java-solution-with-thinking-process-o-nm-time-and-o-m-space/2

read the comment section
for repeating count and non-repeating count version of the problem

optional explanation

https://www.youtube.com/watch?v=PafJOaMzstY

https://www.youtube.com/watch?v=ZaVM057DuzE



*/