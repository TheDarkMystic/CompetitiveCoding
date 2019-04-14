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
public class UniquePathsInGrid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        
        int rowNum=A.size();
        int colNum=A.get(0).size();
       
        int[][]  dp= new int[rowNum][colNum];
        
        for(int i=0; i<colNum; i++){
            //First row, once obstacle found, the rest are blocked.
            if(A.get(0).get(i)==1){
                dp[0][i]=0;
                break;
            }
            else dp[0][i]=1;
        }
        
        for(int i=0; i<rowNum; i++){
            //on the first column, if there is an obstacle, the rest are blocked. 
            //no need to continue.
            if(A.get(i).get(0)==1){
                dp[i][0]=0;
                break;
            }
            else dp[i][0]=1;
        }
        
        
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                if(A.get(i).get(j)==1){
                    dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[rowNum-1][colNum-1];
        
    }
}
/*
Links-https://www.interviewbit.com/problems/unique-paths-in-a-grid/
Notes-
Recursion+memo : https://leetcode.com/problems/unique-paths/discuss/23146/Simple-recursive-solution-using-memoization
https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
https://leetcode.com/problems/unique-paths-ii/discuss/23395/Java-Simple-and-clean-DP-solution-easy-to-understand.
*/