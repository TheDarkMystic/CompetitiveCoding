/*
 * 
A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */


public class GridUniquePaths {
    public int uniquePaths(int a, int b) {
        int dp[][]= new int[a][b]; 
        
        //init 1st col
        for(int i=0; i<a; i++)
            dp[i][0]=1;
        
        //init 1st row    
        for(int i=0;i<b; i++)
            dp[0][i]=1;
            
        for(int i=1; i<a; i++){
            for(int j=1; j<b; j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        
        
        return dp[a-1][b-1];
    }
}
/*
Link-
https://www.interviewbit.com/problems/grid-unique-paths/
Notes-
http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/?qa-rewrite=3676/number-of-unique-paths

with obstacle
https://stackoverflow.com/questions/27588652/count-number-of-paths-in-a-grid-using-dynamic-programming

if g[i][j] is dead
  ways[i][j]=0
else
  ways[i][j]=ways[i][j-1]+
              ways[i-1][j]
*/