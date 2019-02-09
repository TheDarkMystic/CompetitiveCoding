/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.SimulationArray;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class KthRowOfPascalTriangle {
    public ArrayList<Integer> getRow(int rowNum) {
	    int A[] = new int[rowNum+1];
        Arrays.fill(A,0);
        A[0]=1;
        
        for(int i=1;i<=rowNum; i++)
            for(int j=i;j>0;j--)
                A[j]=A[j]+A[j-1];
	    
	    ArrayList<Integer> sol= new ArrayList<Integer>();
	    for(int ele: A)
	        sol.add(ele);
	    return sol;
	}
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
NOTES:
https://discuss.leetcode.com/topic/2510/here-is-my-brief-o-k-solution/5

Dry run and try to 
imagine
*/
