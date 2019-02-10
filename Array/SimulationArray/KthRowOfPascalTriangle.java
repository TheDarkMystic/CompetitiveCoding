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
//    public ArrayList<Integer> getRow(int rowNum) {
//	    int A[] = new int[rowNum+1];
//        Arrays.fill(A,0);
//        A[0]=1;
//        
//        for(int i=1;i<=rowNum; i++)
//            for(int j=i;j>0;j--)
//                A[j]=A[j]+A[j-1];
//	    
//	    ArrayList<Integer> sol= new ArrayList<Integer>();
//	    for(int ele: A)
//	        sol.add(ele);
//	    return sol;
//	}
     public ArrayList<Integer> getRow(int A) {
        int lineNum=A+1;
        int prevEle=1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int eleNum=1; eleNum<=lineNum; eleNum++){
            res.add(prevEle);
            prevEle=prevEle*(lineNum-eleNum)/eleNum;
        }
        
        return res;
    }
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
NOTES:
For Commented Solution
https://discuss.leetcode.com/topic/2510/here-is-my-brief-o-k-solution/5

For Uncommented Solution:
https://en.wikipedia.org/wiki/Pascal%27s_triangle#Calculating_a_row_or_diagonal_by_itself
The Kth Row of pascal triangle can be calculated directly using the formula

initialize first ele as prev=1
and calculate subsequent eles using 

pre=pre*(lineNo. - eleNo.)/(eleNo)

*/
