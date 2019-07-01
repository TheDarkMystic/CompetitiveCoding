/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially 
positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health 
point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering 
these rooms; other rooms are either empty (0’s) or contain magic orbs that increase the knight’s health 
(positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or 
downward in each step.

Write a function to determine the knight’s minimum initial health so that he is able to rescue the 
princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he 
follows the optimal path

RIGHT-> RIGHT -> DOWN -> DOWN.

Dungeon Princess: Example 1



Input arguments to function:
Your function will get an M*N matrix (2-D array) as input which represents the 2D grid as described 
in the question. Your function should return an integer corresponding to the knight’s minimum initial 
health required. 



 Note:
The knight’s health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right 
room where the princess is imprisoned.
 */
package interviewprep.DP;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class DungeonPrincess {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int m = A.size(), n = A.get(0).size();
        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j =n-1;j>=0;j--){
                if(i==m-1 && j==n-1) dp[i][j]= Math.max(1,1-A.get(i).get(j));
                else if(i==m-1) dp[i][j]=Math.max(1,dp[i][j+1]-A.get(i).get(j));
                else if(j==n-1) dp[i][j]=Math.max(1,dp[i+1][j]-A.get(i).get(j));
                else dp[i][j]=Math.max(1, Math.min(dp[i+1][j],dp[i][j+1])-A.get(i).get(j));
            }
        }
        return dp[0][0];
    }
}

/*
Link-
https://www.interviewbit.com/problems/dungeon-princess/
Note-

Start from bottom right (not from top left). 
Think Dynamic programming.

There are only 2 positions you can directly go to from i, j. (i+1, j) and (i, j + 1). 
So if you knew the optimal path requirements for (i + 1, j) and (i, j + 1), you could choose the minimum of the two and be done with it.


*/
