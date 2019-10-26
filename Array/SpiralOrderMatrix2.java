/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Input Format:

The first and the only argument contains an integer, A.
Output Format:

Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:

1 <= A <= 1000
Examples:

Input 1:
    A = 3

Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4

Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
 */
package interviewprep.Array.SimulationArray;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class SpiralOrderMatrix2 {
    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
	    int top=0,
	    bottom=n-1,
	    left=0,
	    right=n-1,
	    dir=0,
	    val=1;
	    int[][] matrix=new int[n][n];
	    
	    ArrayList<ArrayList<Integer>> sol= new ArrayList<ArrayList<Integer>>();
	    
	    while(top<=bottom && left<=right){
	        
	        if(dir==0){
	            for(int i=left;i<=right;i++)
	                matrix[top][i]=val++;
    	        top++;
    	        dir=1;
    	        //val++;
	        }else if(dir==1){
        	            for(int i=top;i<=bottom;i++)
        	                matrix[i][right]=val++;
            	        right--;
            	        dir=2;
            	        //val++;
        	        }else if(dir==2){
                	            for(int i=right;i>=left;i--)
                	                matrix[bottom][i]=val++;
                	                //sol.get(bottom).add(i,val);
                    	        bottom--;
                    	        dir=3;
                    	        //val++;
                	        }else if(dir==3){
                        	            for(int i=bottom;i>=top;i--)
                        	                matrix[i][left]=val++;
                        	                //sol.get(i).add(left,val);
                            	        left++;
                            	        dir=0;
                            	        //val++;
                        	        }
	        
	    }
	    
	    for(int i=0;i<n; i++)
	       { sol.add(new ArrayList<Integer>());
	        for(int j=0;j<n;j++)
	            sol.get(i).add(matrix[i][j]);
	       }
	    
	    return sol;
	}
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/spiral-order-matrix-ii/
NOTES:
https://leetcode.com/submissions/detail/106048459/

https://www.youtube.com/watch?v=siKFOI8PNKM&feature=player_embedded
*/
