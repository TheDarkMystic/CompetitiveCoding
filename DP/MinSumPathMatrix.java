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
public class MinSumPathMatrix {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int rowNum=A.size();        
        int colNum=A.get(0).size();
        
        int dp[][]= new int[rowNum][colNum];
        
        // initialize the fist element
        dp[0][0]= A.get(0).get(0);
        
        // populate the first column with running sum of first column from matrix
        // as there is no other way to reach element in first col than to keep going down
        for(int i=1;i<rowNum; i++) dp[i][0]= dp[i-1][0]+A.get(i).get(0);
        // populate first row with same reasoning as mentioned for first col
        for(int j=1; j<colNum; j++) dp[0][j]=dp[0][j-1]+A.get(0).get(j);
        
        
        // popupulate DP table
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                dp[i][j]= Math.min(dp[i][j-1], dp[i-1][j])+ A.get(i).get(j);
            }
        }

        return dp[rowNum-1][colNum-1];
    }
}


/*
https://www.geeksforgeeks.org/min-cost-path-dp-6/
https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MinCostPath.java

https://www.youtube.com/watch?v=lBRtnuxg-gU

https://discuss.leetcode.com/topic/5459/my-java-solution-using-dp-and-no-extra-space/9
*/
